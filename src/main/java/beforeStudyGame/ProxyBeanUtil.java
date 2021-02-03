package beforeStudyGame;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现
 */
public class ProxyBeanUtil implements InvocationHandler {

    //被代理对象，也就是真实对象
    private Object target;

    //保存拦截器
    private Interceptor interceptor = null;

    /**
     * 获取代理对象
     * @param target 真实对象
     * @param interceptor 拦截器
     * @return
     */
    public static Object getBean(Object target,Interceptor interceptor){
        //！！私有属性，在自身的类中是可以访问的
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.target = target;
        _this.interceptor = interceptor;
        //生成代理对象，并绑定代理方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),_this);
    }

    /**
     * 代理方法
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //该方法返回参数
        Object returnObj = null;
        //判定是否发生异常
        boolean exceptionFlag = false;
        //方法调用之前
        interceptor.before(target);
        try{
            //调用方法
            returnObj = method.invoke(target,args);
        }catch (Exception e){
            //发生异常
            exceptionFlag = true;
        }finally {
            interceptor.after(target);
        }
        if(exceptionFlag){
            //发生异常调用方法
            interceptor.afterThrowing(target);
        }else{
            //未发生异常调用方法
            interceptor.afterReturning(target);
        }

        return returnObj;
    }
}
