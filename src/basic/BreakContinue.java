package basic;

/**
 * @author DF
 */
public class BreakContinue {
    public static void main(String[] args) {
        // break可以跳出语句块
        label:
        {
            if (true) {
                break label;
            }
            System.out.println("无法到达的语句");
        }

        // continue也可以带标签

        // break与continue是可选的，可以完全不用，一样能表达相同的语义

        // 多层break continue
        for (int i = 0; i < 3; i++) {
            loop: for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.println(String.format("i, j, k = %s, %s, %s", i, j, k));
//                    break loop;
                    continue loop;
                }
            }
        }
    }
}
