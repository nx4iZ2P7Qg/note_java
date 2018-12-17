package basic;

/**
 * @author DF
 */
public class DoubleDemo {
    /**
     * java的可移植性与与浮点数计算精度问题
     * double是64位的，但有些处理器使用80位寄存器，从而中间计算时精度更高，跨平台就无法实现
     * 初始java规定每步都要截断，因为可能会导致溢出，同时降低性能
     * 最终折衷方案，默认情况下，中间步骤允许使用扩展的指数，不允许扩展的尾数
     * 使用strictfp关键字标记的类或方法就截断
     * 实际的方式将取决于处理器，这两种方式的差别在于溢出，对大多数程序员来说不是大问题
     * 本类的main方法就是这种
     */
    public static strictfp void main(String[] args) {

        // double 8字节
        // 16进制表示浮点数方法，尾数16进制，指数基数2，指数10进制
        double d1 = 0x1.0p-3;
        System.out.println("0x1.0p-3 = " + d1);

        // Double.POSITIVE_INFINITY
        System.out.println("1.0 / 0 = " + 1.0 / 0);
        // Double.NEGATIVE_INFINITY
        System.out.println("-1.0 / 0 = " + -1.0 / 0);

        // 正负无穷大的判断
        System.out.println(1.0 / 0 == Double.POSITIVE_INFINITY);
        // 负无穷大类似

        // Double.NaN
        System.out.println(0.0 / 0);
        System.out.println(0 / 0.0);
        // 判断
        System.out.println("非数判断" + Double.isNaN(0.0 / 0));

        // 特别的，异常
        try {
            System.out.println(0 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        // 浮点数不适用于禁止出现舍入误差的应用场合，尤其是金融
        // 主要原因是浮点数用二进制表示，无法精确表示1/10
        // 就好像整数无法精确表示1/3
    }
}
