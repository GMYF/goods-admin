package com.light.springboot.core.controller;


import com.light.springboot.common.cache.local.LocalCache;
import com.light.springboot.common.constants.SystemConstants;
import com.light.springboot.core.domain.user.User;
import com.light.springboot.common.exception.CustomException;
import com.light.springboot.core.service.UserService;
import com.light.springboot.util.info.CodeMsg;
import com.light.springboot.util.io.IoUtils;
import com.light.springboot.util.json.JsonUtil;
import com.light.springboot.util.response.ResponseResult;
import com.light.springboot.util.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author add00
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @GetMapping("/detail/{id}")
    public ResponseResult<User> getUserDetail(@PathVariable int id) {
        if (id <= 0) {
            throw new CustomException(CodeMsg.USER_NO_ID);
        }
        User user = userService.findById(id);
        return ResponseResult.success(user);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestParam Map map, HttpServletRequest request, HttpServletResponse response) {
        String username = StringUtils.safe2String(map.get("username"));
        String password = StringUtils.safe2String(map.get("password"));
        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1000 * 30);
            session.setAttribute("token", user.getToken());
            // 存入本地缓存
            LocalCache.getCache().put(SystemConstants.LOGIN_TOKEN_KEY_PREFIX + user.getToken(), JsonUtil.toString(user));
            // 存入redis
            redisTemplate.opsForValue().set(SystemConstants.LOGIN_TOKEN_KEY_PREFIX + user.getToken(), JsonUtil.toString(user));
        }else {
            throw CustomException.CHECK_USER_FAILED;
        }
        return new ResponseResult();
    }

    @PostMapping("/add")
    public ResponseResult addUser(@RequestParam Map map) {
        String username = StringUtils.safe2String(map.get("username"));
        User user = new User();
        user.setName(username);
        user.setPhone("");
        userService.addUser(user);
        return null;
    }

    @PostMapping("/file")
    public ResponseResult addFile(@RequestParam("file") MultipartFile file) {
        //file是form-data中二进制字段对应的name
        System.out.println(file);
        try {
            IoUtils.readFile(file.getInputStream(),file.getName(),file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseResult();
    }
}
