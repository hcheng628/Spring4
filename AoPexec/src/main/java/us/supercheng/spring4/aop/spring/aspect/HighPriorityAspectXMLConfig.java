package us.supercheng.spring4.aop.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class HighPriorityAspectXMLConfig {

    public double doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("******HighPriorityAspect Around before is running!");
        double result = (Double) joinPoint.proceed(); //continue on the intercepted method
        System.out.println("******HighPriorityAspect Around after is running!");
        return result;
    }
}