import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理：
 * 代理工厂，给多个目标对象生成代理对象！
 */
class ProxyFactory {
    // 接收一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回对目标对象(target)代理后的对象(proxy)
    public Object getProxyInstance() {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 目标对象使用的类加载器
                target.getClass().getInterfaces(),   // 目标对象实现的所有接口
                (Object proxy2, Method method, Object[] args) -> {
                    Object result = null;
                    long start = System.nanoTime();
                    System.out.println("执行方法为：" + method.getName());
                    result = method.invoke(target, args);
                    System.out.println("执行完毕，耗时为:" + (System.nanoTime() - start) / 1000000.0 + "s");
                    return result;
                }

        );
        return proxy;
    }

}