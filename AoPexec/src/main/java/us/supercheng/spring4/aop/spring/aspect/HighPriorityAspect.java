package us.supercheng.spring4.aop.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class HighPriorityAspect {
    /* */
    private final String APPLIED_CLASS = "execution(* us.supercheng.spring4.aop.spring.service.CalImpl.*(..))";

    @Around(("us.supercheng.spring4.aop.spring.aspect.LoggingAspect.doDeclearPointcut()"))
    public double doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("******HighPriorityAspect Around before is running!");
        double result = (Double) joinPoint.proceed(); //continue on the intercepted method
        System.out.println("******HighPriorityAspect Around after is running!");
        return result;
    }
}