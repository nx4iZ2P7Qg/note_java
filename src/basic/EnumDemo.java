package basic;

import java.util.Arrays;

/**
 * @author DF
 */
public class EnumDemo {
    public static void main(String[] args) {

        // 枚举类，见后面的Size类
        Size s = Size.MEDIUM;
        s = null;

        // 枚举类定义时，括号内就是实例，不要构造新对象
        // 比较时，直接使用==
        // 枚举类是Enum的子类

        // 转字符
        // LARGE
        System.out.println(Size.LARGE.toString());

        // 从字符转
        // Size.SMALL
        System.out.println(Size.valueOf(Size.class, "SMALL"));

        // 全部常量
        // [SMALL, MEDIUM, LARGE, EXTRA_LARGE]
        System.out.println(Arrays.toString(Size.values()));

        // 声明中的位置
        // 2
        System.out.println(Size.LARGE.ordinal());
    }
}

enum Size {
    /**
     *
     */
    SMALL, MEDIUM, LARGE, EXTRA_LARGE
}
