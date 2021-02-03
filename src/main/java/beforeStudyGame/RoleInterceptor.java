package beforeStudyGame;

/**
 * 自定义role拦截器实现类
 */
public class RoleInterceptor implements Interceptor{
    @Override
    public void before(Object obj) {
        System.out.println("开始执行方法！");
    }

    @Override
    public void after(Object obj) {
        System.out.println("方法执行完毕！");
    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("无异常发生，good！");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("哇偶，发生异常了");
    }
}
