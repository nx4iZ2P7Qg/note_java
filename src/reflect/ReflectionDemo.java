package reflect;

/**
 * @author DF
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        // 5
        // 反射是指在程序运行期间发现更多的类及其属性的能力
    }

    public void function1() {
        // 5.1
        // 一个变量可以指示引用多种类型叫多态
        // 在运行时可以自动选择调用哪个方法叫动态绑定

        // 5.1.3
        // 返回类型不是方法签名的一部分，所以在子类重写方法时，要注意保证返回类型的兼容性，允许子类的返回类型为原类型的子类
        // private static final方法或构造器，编译器可以准确定位方法，称为静态绑定
        // 虚拟机为每个类创建了一个方法表，每次动态绑定调用方法时都要搜索

        // 5.1.4
        // 如果将一个类声明为final，其中所有方法都会被声明为final，域不会

        // 5.1.5
        // 类型判断
        Integer integer515 = 0;
        if (integer515 instanceof Object) {
            System.out.println((Object) integer515);
        }
        // 通过类型转换调整类型不是一种很好的做法
        // 只有在使用子类特有方法时才需要转换，这种情况最好重新设计超类，添加对应方法
        // 一般情况下，尽量少用类型转换与instanceof

        // 5.1.6
        // 继续抽象带来abstract方法与类的概念
        // 抽象类可以有具体域与方法
        // 抽象方法充当占位的角色，具体实现在子类中，子类可以实现部分方法或完全不实现（也是abstract），或完全实现

        // 5.1.7
        // 继承可以使子类获得超类所有域与方法，但private的就不行，希望子类访问时要使用protected
        // protected的域违背了封装，要谨慎使用
        // protected的方法更具有实际意义
        // 实际上java中的protected对所有子类及同包中的其他类都可见
    }

    public void function2() {
        // 5.2
        // java中只有基本类型不属于对象，数组属于对象

        // 5.2.1
        // 子类中定义equals方法时，要考虑调用超类equals

        // 5.2.2
        // 如果equals两者类型不同时，该如何处理有争议
        // 如何写一个标准的equals方法

        // 5.2.3
        // Object中的toString()输出串最后的16进制数也是内存地址，它和hashCode()的值相同
        Object o523 = new Object();
        Integer i5231 = Integer.valueOf(o523.toString().substring(17), 16);
        System.out.println(i5231);
        Integer i5232 = o523.hashCode();
        System.out.println(i5232);
        // hashCode()的建议写法
    }

    public void function4() {
        // 5.4
        // 数值型包装类Integer, Long等等，有公共超类Number，其他包装类Void, Character
        // 包装类不可变，且final
        // 自动boxing, unboxing是在编译时完成的，jvm不参与
    }

    public void function5() {
        // 5.7
        // 能够分析类能力的程序称为反射

        // 5.7.1
        // java程序运行时，系统为所有对象维护了一份runtime type identification
        // jvm使用以上标识选择正确的方法执行
        // 获取Class，方法一
        // class java.lang.String
        System.out.println(new String().getClass());
        // 获取Class，方法二
        try {
            Class<?> c = Class.forName("java.util.Date");
            // class java.util.Date
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获取Class，方法三
        // class java.lang.Integer
        System.out.println(Integer.class);
        // int is not a class, but int.class is nevertheless an object of type Class.
        // java5中，Employee.class is of type Class<Employee>
        // 历史原因，getName方法返回的串有些怪
        // Double[].class.getName() returns "[Ljava.lang.Double;"
        // int[].class.getName() returns "[I"
        // 对每一个type，jvm管理一个唯一的Class，直接使用 == 判断
        System.out.println(int.class == Integer.class);
        // 一个快速创建实例的方法，只能用于调用无参的构造器
        String s57 = "java.util.Date";
        try {
            Object m = Class.forName(s57).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 如果要使用参数，参考key_reflection_Contructor_newInstance

        // 5.7.3
        // 反射机制最重要的内容——检查类的结构
        // java.lang.reflect包中三个类Field, Method, Constructor用于描述，它们都有getName()方法
        // Field的getType()方法描述成员的Class对象
        // Method, Constructor有方法可以报告参数类型，Method还可以报告返回类型
        // getModifier()返回public, static的描述符，这个值可以用Modifier的静态方法分析，如isPublic()
        // Class中的getFields(), getMethods(), getConstructors()返回对应数组，包括超类
        // getDeclareFields(), getDeclareMethod(), getDeclareConstructors()不包含超类，但包含私有
        // 参考key_Constructor_Method_Field

        // 5.7.4
        // 利用反射查看编译时还不清楚的对象
    }
}
