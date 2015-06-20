package com.woom.tools.effecitve;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by yuhao.zx on 14-12-7.
 */
@Component("effective")
@Aspect
public class EffectiveAspect {
    @Around("execution(* com.woom.tools.guava..*(..))")
    public Object doAroundMethod(ProceedingJoinPoint pjg) throws Throwable {
        try{
            Class t = pjg.getTarget().getClass();
            long s = System.currentTimeMillis();
            pjg.getTarget();
            Object obj = pjg.proceed();
            long e = System.currentTimeMillis();
            System.out.println(t.getName()+"."+pjg.getSignature().getName()+"() cost:"+(e-s)+" ms");
            return obj;
        }catch (Exception e){
            System.out.println(e.toString());
            throw e;
        }
    }
}
