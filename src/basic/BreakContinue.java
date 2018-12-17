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
    }
}
