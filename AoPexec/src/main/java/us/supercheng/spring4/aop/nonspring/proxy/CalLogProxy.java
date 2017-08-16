package us.supercheng.spring4.aop.nonspring.proxy;

import us.supercheng.spring4.aop.nonspring.service.CalImpl;
import us.supercheng.spring4.aop.nonspring.service.ICal;
import java.util.Arrays;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalLogProxy {
    private ICal target;

    public CalLogProxy (ICal target) {
        this.target = target;
    }

    public ICal getCalLogProxyInstance() {
        ClassLoader targetClassLoader = this.target.getClass().getClassLoader();
        // Class [] targetClass = this.target.getClass().getClasses();
        Class [] targetClass = new Class[] {ICal.class};

        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Enter " + method.getName() + " " + Arrays.toString(args));
                Object obj = method.invoke(target, args);
                System.out.println("Exit " + method.getName() + " " + Arrays.toString(args));
                return obj;
            }
        };
        return (ICal) Proxy.newProxyInstance(targetClassLoader, targetClass, invocationHandler);
    }
}