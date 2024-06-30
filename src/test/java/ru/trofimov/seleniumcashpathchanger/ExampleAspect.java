package ru.trofimov.seleniumcashpathchanger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.openqa.selenium.manager.SeleniumManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ExampleAspect {

    @Pointcut("execution(private * org.openqa.selenium.manager.SeleniumManager.getBinaryInCache(..))")
    public void myPrivateMethodPointcut() {
    }

    @Around("myPrivateMethodPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        String cachePath = "C:/Work/Cash/SeleniumCash";
        return joinPoint.proceed(args);
    }
}
