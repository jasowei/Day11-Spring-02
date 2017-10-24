package com.lanou.cglib;

import com.lanou.aop.LogUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by dllo on 17/10/24.
 */
public class CGlibProxy implements MethodInterceptor{

    private Object target;//目标对象
    private LogUtil logUtil;//要插入的日志对象


    /**
     * 获得目标对象生成的代理对象
     * @param object
     * @return
     */
    public Object getProxyObject(Object object){
        target = object;//重新赋值目标对象

        //1. 创建增强类对象
        Enhancer enhancer = new Enhancer();
        //2. 设置回调接口, 即设置方法拦截器
        enhancer.setCallback(this);
        //3. 设置父类class
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();//创建代理类并返回

    }

    /**
     * 拦截目标对象的方法执行
     * @param o     被代理后的对象
     * @param method   目标对象中的执行方法
     * @param objects     方法中的参数列表
     * @param methodProxy    代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //前置日志
        logUtil.startMethod();
        //
        Object result = method.invoke(target,objects);
        //后置日志
        logUtil.endMethod();
        return result;//返回方法执行结果
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
