package basic;

import java.util.Arrays;

/**
 * @author DF
 */
public class ArrayDemo {
    public static void main(String[] args) {

        // 创建数组时，若为数字类型，所有值为0，boolean则所有元素为false，对象则所有元素为null

        // 二维数据输出用deepToString
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                new int[3]
        };
        System.out.println(Arrays.deepToString(arr));

        // 3.10.7
        // 不规则数组
        int length = 3;
        int[][] odds = new int[length][];
        for (int li = 0; li < length; li++) {
            odds[li] = new int[li + 1];
        }
        System.out.println(Arrays.deepToString(odds));
    }
}
