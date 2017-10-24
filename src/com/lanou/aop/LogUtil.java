package com.lanou.aop;

/**
 * Created by dllo on 17/10/24.
 */
public class LogUtil {

    /**
     * 方法执行前的前置日志
     */
    public void startMethod(){
        System.out.println("----startMethod---");
    }

    /**
     * 方法执行后的后置日志
     */
    public void endMethod(){
        System.out.println("----endMethod---");
    }

}
