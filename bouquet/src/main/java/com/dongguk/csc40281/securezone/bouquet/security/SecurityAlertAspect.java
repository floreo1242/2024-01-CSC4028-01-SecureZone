package com.dongguk.csc40281.securezone.bouquet.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAlertAspect {

    @AfterThrowing(pointcut = "execution(* com.dongguk.csc40281.securezone.bouquet.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        if (ex instanceof SecurityException) {
            // 비정상적인 접근 시도 알림 로직
            System.out.println("Security alert: " + ex.getMessage());
            // 추가로 이메일이나 메시지 알림 전송 로직 포함
        }
    }

}
