package com.lanou.aop;

import com.lanou.cglib.CGlibProxy;
import org.junit.Test;

/**
 * Created by dllo on 17/10/24.
 */
public class JDKProxyTest {


    /**
     * 测试jdk动态代理的实现方式
     */
    @Test
    public void test_JDKProxy(){
        //1. 创建目标业务对象
        Calculation calculation = new Calculation();
        //2. 创建要插入的日志对象
        LogUtil logUtil = new LogUtil();
        //3. 创建代理工具类
        CalculationProxy proxy = new CalculationProxy();
        proxy.setLogUtil(logUtil);
        //4. 从工具类中获得代理对象(接口)
        ICalculation calculationProxy = (ICalculation) proxy.getProxyObject(calculation);
        //5. 通过代理对象调用业务方法
        calculationProxy.add(2,8);
        System.out.println("**************");
        calculationProxy.sub(3,4);
    }


    /**
     * 测试CGlib实现的动态代理方式
     */
    @Test
    public void testCGlibProxy(){
        //目标对象
        Calculation target = new Calculation();
        //要插入的业务对象
        LogUtil logUtil = new LogUtil();
        //创建代理工具类
        CGlibProxy cGlibProxy = new CGlibProxy();
        cGlibProxy.setLogUtil(logUtil);//设置日志对象

        //通过获得代理工具类获得代理对象
        Calculation calculation = (Calculation) cGlibProxy.getProxyObject(target);

        //调用目标对象的方法
        calculation.add(3,4);

    }
}
