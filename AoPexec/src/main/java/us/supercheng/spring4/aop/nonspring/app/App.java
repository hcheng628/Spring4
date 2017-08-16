package us.supercheng.spring4.aop.nonspring.app;

import us.supercheng.spring4.aop.nonspring.proxy.CalLogProxy;
import us.supercheng.spring4.aop.nonspring.service.CalImpl;

public class App {
    public static void main(String [] args) {
        CalImpl cal = new CalImpl();
        CalLogProxy calProxy = new CalLogProxy(cal);
        System.out.println(calProxy.getCalLogProxyInstance().add(1,2));
    }
}