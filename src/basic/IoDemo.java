package basic;

import java.io.Console;
import java.util.Scanner;

/**
 * @author DF
 */
public class IoDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s371 = sc.nextLine();
        sc.nextInt();
        sc.nextDouble();
        sc.close();
        // Scanner不适合输入密码，se6加入了console
        // 以下代码在ide中运行会得到空的cons，因为不是在terminal中运行，ide进行了重定向
        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Password: ");
        // passwd使用后应立即填充
    }
}
