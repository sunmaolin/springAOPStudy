package aspectConfig;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 创建切面
 * 表达式分析：execution(* service.impl.RoleServiceImpl.printRole(..))
 * execution:代表在执行这个方法时会触发
 *  * 代表方法的任意返回类型
 * service.impl.RoleServiceImpl：代表类的全限定名
 * printRole：代表拦截的方法名称
 * （..）:代表任意的参数
 *
 * 当然还有其他的指示器
 * arg()限制连接点匹配参数为指定类型的方法
 * @arg()限制连接点匹配参数为指定注解标注的执行方法
 * execution用于匹配连接点的执行方法
 * this()限制连接点匹配AOP代理的Bean，引用为指定类型的类
 * target限制连接点匹配被代理对象为指定的类型
 * @target限制连接点匹配特定的执行对象，这些对象要符合指定的注解类型
 * within()限制连接点匹配指定的包
 * @within()限制连接点匹配指定的类型
 * @annotation限定匹配带有指定注解的连接点
 * 比如：
 * 匹配impl报下的所有类的printRole方法，但不包含aaa包中的方法
 * execution(* service.impl.*.*.printRole(..)) && within(service.impl.*.aaa)
 */
//Aspect注解说明这是一个切面
@Aspect
@Component
public class RoleAspect {

    /**
     * 一个个定义太麻烦，可以先定义好一个切点，下面进行引用
     */
    @Pointcut("execution(* service.impl.RoleServiceImpl.printRole(..))")
    public void print(){

    }

    @Before("execution(* service.impl.RoleServiceImpl.printRole(..))")
    public void before(){
        System.out.println("before...");
    }

    @After("execution(* service.impl.RoleServiceImpl.printRole(..))")
    public void after(){
        System.out.println("after...");
    }

    @AfterReturning("print()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    @AfterThrowing("print()")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }
}
