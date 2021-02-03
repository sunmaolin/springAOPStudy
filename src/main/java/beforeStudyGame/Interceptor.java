package beforeStudyGame;

/**
 * 自定义拦截器接口
 */
public interface Interceptor {
    /**
     * 执行方法之前调用
     * @param obj
     */
    void before(Object obj);

    /**
     * 执行方法之后调用
     * @param obj
     */
    void after(Object obj);

    /**
     * 执行方法之后无异常调用
     * @param obj
     */
    void afterReturning(Object obj);

    /**
     * 执行方法之后发生异常调用
     * @param obj
     */
    void afterThrowing(Object obj);
}
