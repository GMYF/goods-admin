package com.light.springboot.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
    private Logger logger = LoggerFactory.getLogger(AspectDemo.class);
    /**
     * 切面点,最常用的切点函数
     * execution 表达式主体
     * 第一个*号 表示返回类型，*号表示所有的类型
     * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包 -- com.light.springboot.core.controller..
     * 包后面的* 表示类名，*号表示所有的类
     * *(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     * 总结：要切入到com.light.springboot.core.controller包下任意的controller类的任意方法，任意参数，任意返回值
     */
    private static final String POINT_CUT = "execution(* com.light.springboot.core.controller..*.*(..))";
    /**
     * 切入方法
     */
    @Pointcut(POINT_CUT)
    private  void pointCut() {
        logger.info("已执行切面方法");
    }

    /**
     * 前置调研，切面方法被执行前调用
     */
    @Before(value = POINT_CUT)
    private void before(JoinPoint joinPoint) {
        logger.info("前置通知");
        // 获取目标方法的参数信息
        Object[] params = joinPoint.getArgs();



    }
}
