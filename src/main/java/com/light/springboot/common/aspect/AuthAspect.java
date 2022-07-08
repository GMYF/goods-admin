package com.light.springboot.common.aspect;

import com.light.springboot.common.annotation.PassList;
import com.light.springboot.common.exception.CustomException;
import com.light.springboot.util.info.CodeMsg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AuthAspect {
    private Logger logger = LoggerFactory.getLogger(AuthAspect.class);
    /**
     * 切面点,最常用的切点函数
     *
     */
    private static final String POINT_CUT = "@annotation(com.light.springboot.common.annotation.PassList)";
    /**
     * 切入方法
     */
    @Pointcut(POINT_CUT)
    private  void whitelistPointcut() {
        logger.info("已执行切面注解方法: PassList");
    }

    /**
     * 前置调研，切面方法被执行前调用
     */
    @Before(value = "whitelistPointcut() && @annotation(passList)")
    private void before(JoinPoint joinPoint, PassList passList) {
        logger.info("前置通知");
        // 获取目标方法的参数信息
        Object[] params = joinPoint.getArgs();
        Arrays.stream(params).forEach(obj-> {
           String name =  obj instanceof  String ? ((String) obj) : null;
           if (!passList.value().contains(name)){
                throw new CustomException(CodeMsg.AUTH_ERROR);
           }
        });
    }
    @After(value = "whitelistPointcut()")
    private void after() {
        logger.info("后置通知");
    }
}
