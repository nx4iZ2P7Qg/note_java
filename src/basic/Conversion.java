package basic;

/**
 * @author DF
 */
public class Conversion {
    public static void main(String[] args) {

        // int转double没有精度损失，long转double可能有

        // 7个基本类型计算时，优先转成double, float, long, int，再运算

        // 强转，且数值超过类型的范围，数据会乱
        // 44
        System.out.println((byte) 300);
    }
}
