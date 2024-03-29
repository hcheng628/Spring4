package us.supercheng.spring4.aop.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

    private final String APPLIED_CLASS = "execution(* us.supercheng.spring4.aop.spring.service.CalImpl.*(..))";

    @Pointcut(APPLIED_CLASS)
    public void doDeclearPointcut(){}

    @Before("doDeclearPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("Enter and Validate -> Method: " + joinPoint.getSignature().getName() + " Args: " + Arrays.asList(joinPoint.getArgs()));
    }

    @After("doDeclearPointcut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("Exit ->  Method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = ("doDeclearPointcut()"), returning = "retVal")
    public void doAfterReturning(JoinPoint joinPoint, Object retVal) {
        System.out.println("Enter and Validate -> Method: " + joinPoint.getSignature().getName() + " Result: " + retVal.toString());
    }

    @AfterThrowing(value = ("doDeclearPointcut()"),throwing = "customEx")
    public void doAfterThrowing(JoinPoint joinPoint, RuntimeException customEx) {
        System.out.println("Exception occurs " + customEx.getMessage());
    }
}