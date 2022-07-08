package com.light.springboot.core.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/dashboard")
public class DashBoardController {

    @GetMapping("/index")
    public String directPage() {
        return "index";
    }
}
