package hello;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class GreetingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(GreetingAspect.class);

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(* *(..))")
    public Object aroundRestCall(final ProceedingJoinPoint jointPoint)
        throws Throwable
    {
        LOG.warn("Intercepted: {}", jointPoint.getSignature().getName());

        return jointPoint.proceed();
    }
}
