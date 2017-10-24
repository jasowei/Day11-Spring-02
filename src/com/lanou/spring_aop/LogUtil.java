package com.lanou.spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dllo on 17/10/24.
 *
 *
 * 切面  Aspect
 *
 *
 * @Component :  相当于<bean id="logUtil" class="com.lanou.spring_aop.LogUtil"/>
 * @Aspect : 指明当前类是一个切面类, 相当于<aop:aspect ref="logUtil"/>
 */
@Component
@Aspect
public class LogUtil {

    /**
     * 定义切入点表达式
     * 相当于: <aop:pointcut expression="..."/>
     */
    @Pointcut("execution(* com.lanou.spring_aop.Calculation.*(..))")
    private void method(){

    }


    /**
     * 前置通知 Advice
     */
    @Before("method()")
    public void startAdvice(JoinPoint joinPoint){
        System.out.println("前置通知: startAdvice");
        //获得当前调用的方法名
        String method = joinPoint.getSignature().getName();
        System.out.println("方法名 : "+method);
        System.out.println("目标类 : "+joinPoint.getTarget().getClass());
    }


    /**
     * 后置通知 Advice
     */
    @After("method()")
    public void endAdvice(JoinPoint joinPoint){
        System.out.println("后置通知: endAdvice");

        //获得当前调用的方法名
        String method = joinPoint.getSignature().getName();
        System.out.println("方法名 : "+method);
        System.out.println("目标类 : "+joinPoint.getTarget().getClass());

    }
}
