package basic;

/**
 * @author DF
 */
public class CharDemo {
    public static void main(String[] args) {
        char c1 = 'A';
        System.out.println(c1);
        // 与'A'相同的16进制unicode表示方法
        char c2 = '\u0041';
        System.out.println("c2 = " + c2);

        // 16进制unicode表示范围为\u0000 ~ \uffff
        char c3 = '\uffff';
        System.out.println("c3 = " + c3);

        // 特别的  ™ π
        System.out.println('\u2122');
        System.out.println('\u03c0');

        // unicode与utf-16的一个例子
        // utf-16中常用字是2Byte16位，最大65536个字符，生僻字用4Byte32位储存
        // 无论哪种，一个Integer可以装下
        // 比如𤭢，在unicode中它的代码点(code point)是U+24B62
        // 转换成UTF-16编码，过程如下
        // 1.减去0x10000，结果为0x14B62，二进制为0001_0100_1011_0110_0010
        // 2.高10位(0001_0100_10，0x052)加上0xD800，结果为0xD852
        // 3.低10位(11_0110_0010，0x362)加上0xDC00，结果为0xDF62
        // 最终是 D852 DF62，过程可逆向转换
        // unicode多语言级别中空闲的2048个字节，人为的分为两段
        // 0xD800，0xDC00是这两段的开始地址，U+D800~U+DBFF，U+DC00~U+DFFF
        // 代码点初始化
        char[] chars1 = Character.toChars(0x24B62);
        // 𤭢
        System.out.println(chars1);
        // 字符串初始化
        String s1 = "\uD852\uDF62";
        System.out.println(s1);
        // 强烈建议不要在代码中使用char类型

        // 3.4
        // 不推荐，但合法的变量名起始字符
        System.out.println(Character.isJavaIdentifierStart('变'));
        // 不推荐，但合法的变量名非起始字符
        System.out.println(Character.isJavaIdentifierPart('变'));
        // 不要使用$作变量名，javac要使用
    }
}
