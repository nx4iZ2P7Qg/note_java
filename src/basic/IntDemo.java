package basic;

/**
 * @author DF
 */
public class IntDemo {
    public static void main(String[] args) {
        // 16进制整数
        int int1 = 0x10;
        // 16
        System.out.println("int1 = " + int1);

        // 不建议使用的8进制整数
//        int int2 = 010;

        // 2进制数
        int int3 = 0b10;
        // 2
        System.out.println("int3 = " + int3);

        // 整形的位运算
        // & | ^ ~
        // >> << >>>，右侧移动位数，要根据被操作数的类型取模，比如int模32，long模64
    }
}
