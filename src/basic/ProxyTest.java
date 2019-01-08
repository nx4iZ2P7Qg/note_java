package basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 代理的使用
 * <p>
 * 可以在运行时创建一个实现了一组给定接口的新类，只有在编译时无法确定需要实现哪个接口时才有必要使用
 *
 * @author Cay Horstmann
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1 ... 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            // 创建代理对象
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            // 用代理对象填充数组
            elements[i] = proxy;
        }
        // 查找随机数
        Integer key = new Random().nextInt(elements.length) + 1;
        // 调用compareTo
        int result = Arrays.binarySearch(elements, key);
        // 找到
        if (result >= 0) {
            // 调用toString
            System.out.println(elements[result]);
        }
    }
}

/**
 * An invocation handler that prints out the method name and parameters, then
 * invokes the original method
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Constructs a TraceHandler
     *
     * @param t the implicit parameter of the method call
     */
    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + m.getName() + "(");
        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        // 反射中的Method.invoke，调用方法
        return m.invoke(target, args);
    }
}
