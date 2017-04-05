package sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    @Before("execution(* sample..*(..))")
    public void logMethodCallForAnyNonFinalMethod(JoinPoint joinPoint) {
        LoggerFactory.getLogger(joinPoint.getTarget().getClass()).info("called: {}({})",
                joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
}
