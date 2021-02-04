package xmlAop.aspectConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import pojo.Role;
import verifier.RoleVerifier;

public class RoleAspect {

    public RoleVerifier roleVerifier;

    public void before(Role role){
        System.out.println("是否传入参数："+(role != null));
        System.out.println("before...");
    }

    public void after(){
        System.out.println("after...");
    }

    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    public void around(ProceedingJoinPoint jp){
        System.out.println("aroundBefore...");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aroundAfter..");
    }

}
