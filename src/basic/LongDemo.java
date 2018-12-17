package basic;

/**
 * @author DF
 */
public class LongDemo {
    public static void main(String[] args) {
        // java7支持长整数添加下划线方便阅读
        long long1 = 12_3456_7890_0000_0000L;
        // 123456789000000000
        System.out.println("long1 = " + long1);

        long long2 = 0b111_1111_1000_0000;
        // 32640
        System.out.println("long2 = " + long2);
    }
}
