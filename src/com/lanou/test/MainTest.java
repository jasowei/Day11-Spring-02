package com.lanou.test;

import com.lanou.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/24.
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init(){
        //1. 启动spring容器
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }


    /**
     * 测试Resource注解
     */
    @Test
    public void test(){
        PersonServiceImpl personService = (PersonServiceImpl) context.getBean("personService");
        System.out.println(personService.login("jd", "123"));
    }


}
