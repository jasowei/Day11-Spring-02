package com.lanou.spring_aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/24.
 */
public class AopTest {

    private ApplicationContext context;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-aop.xml");
    }

    /**
     * 使用xml方式配置切面
     */
    @Test
    public void testXML(){
        Calculation calculation = (Calculation) context.getBean("calculation");
        int add = calculation.add(2, 4);
        System.out.println(add);
    }

}
