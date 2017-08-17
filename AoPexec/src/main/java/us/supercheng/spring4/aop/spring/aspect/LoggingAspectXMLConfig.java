package us.supercheng.spring4.aop.spring.aspect;

import org.aspectj.lang.JoinPoint;
import java.util.Arrays;

public class LoggingAspectXMLConfig {

    public void doBefore(JoinPoint joinPoint) {
        System.out.println("Enter and Validate -> Method: " + joinPoint.getSignature().getName() + " Args: " + Arrays.asList(joinPoint.getArgs()));
    }

    public void doAfter(JoinPoint joinPoint) {
        System.out.println("Exit ->  Method: " + joinPoint.getSignature().getName());
    }

    public void doAfterReturning(JoinPoint joinPoint, Object retVal) {
        System.out.println("Enter and Validate -> Method: " + joinPoint.getSignature().getName() + " Result: " + retVal.toString());
    }

    public void doAfterThrowing(JoinPoint joinPoint, RuntimeException customEx) {
        System.out.println("Exception occurs " + customEx.getMessage());
    }
}