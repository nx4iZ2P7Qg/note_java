package basic;

import java.io.FileInputStream;

public class StreamDemo {
    public static void main(String[] args) throws Exception {
        // 待读文件
        String fileName = "d:/abc.txt";
        // 缓存
        byte[] buffer = new byte[1000];
        FileInputStream inputStream = new FileInputStream(fileName);
        // 总字节数
        int total = 0;
        // 读取字节数
        int nRead;
        while ((nRead = inputStream.read(buffer)) != -1) {
            total += nRead;
        }
        // Always close files.
        inputStream.close();
        System.out.println("Read " + total + " bytes");
    }
}
