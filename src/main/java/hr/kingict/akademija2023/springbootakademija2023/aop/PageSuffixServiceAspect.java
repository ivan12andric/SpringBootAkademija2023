package hr.kingict.akademija2023.springbootakademija2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PageSuffixServiceAspect {

    Logger logger = LoggerFactory.getLogger(PageSuffixServiceAspect.class);
    @AfterReturning(value = "execution(* hr.kingict.akademija2023.springbootakademija2023.service.PageSuffixService.getSuffix(..))", returning = "result")
    public void beforePageSuffixServiceGetSuffix( String result){

        logger.error("before page suffix service get suffix: " + result);

    }
}
