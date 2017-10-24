package com.lanou.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dllo on 17/10/24.
 */
public class CalculationProxy implements InvocationHandler{


    private Object target;//目标对象
    private LogUtil logUtil;//日志业务对象

    public CalculationProxy() {
    }

    public CalculationProxy(Object target, LogUtil logUtil) {
        this.target = target;
        this.logUtil = logUtil;
    }

    /**
     * 拦截被JDK动态代理的对象中的所有方法调用
     * @param proxy 被代理的对象
     * @param method 执行的方法(反射)
     * @param args 执行方法所需要的参数列表
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前之日志加入
        logUtil.startMethod();

        //调用目标对象中的方法
        Object result = method.invoke(target,args);

        //后置日志加入
        logUtil.endMethod();


        return result;
    }

    /**
     * 获得目标对象的代理对象
     * @param object
     * @return
     */
    public Object getProxyObject(Object object){
        target = object;//重新指定目标对象
        return Proxy.newProxyInstance(
                //获得目标对象的classloader
                target.getClass().getClassLoader(),
                //获得目标对象的接口集合
                target.getClass().getInterfaces(),
                //指定目标对象的拦截器
                this
        );
    }




    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public LogUtil getLogUtil() {
        return logUtil;
    }

    public void setLogUtil(LogUtil logUtil) {
        this.logUtil = logUtil;
    }
}
