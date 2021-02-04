package aspectConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pojo.Role;
import verifier.RoleVerifier;
import verifier.impl.RoleVerifierImpl;

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
//当同一个切点存在多个切面时，该注解会指定执行顺序
//或者实现接口Ordered 重写getOrder方法，看下面注释掉的代码
@Order(1)
@Component
public class RoleAspect /*implements Ordered*/ {

//    @Override
//    public int getOrder() {
//        return 0;
//    }

    /**
     * 在切面引入一个校验属性
     * + 定义一个增强类
     * default 默认实现类
     */
    @DeclareParents(value = "service.impl.RoleServiceImpl+",defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;

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

    /**
     * 测试环绕通知
     * 测试可知：环绕通知是在before通知之前，after通知之后
     * @param jp
     */
    @Around("print()")
    public void around(ProceedingJoinPoint jp){
        System.out.println("aroundBefore...");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aroundAfter..");
    }

    /**
     * 测试通知添加参数
     * args参数上面有写，只拦截该参数为args的方法
     * @param role
     */
    @Before("execution(* service.impl.RoleServiceImpl.printRole(..)) && args(role,sort)")
    public void beforeByArgs(Role role,int sort){
        System.out.println("beforeRoleId:"+role.getRoleId());
        System.out.println("beforeSort:"+sort);
    }
}
