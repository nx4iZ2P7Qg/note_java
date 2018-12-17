package basic;

/**
 * @author DF
 */
public class StringDemo {
    public static void main(String[] args) {

        // +的结果缓存了，substring的结果没有
        String s361 = "ab";
        String s362 = "a" + "b";
        String s363 = "abstract".substring(0, 2);
        // true
        System.out.println(s361 == s362);
        // false
        System.out.println(s361 == s363);

        // 代码点
        // "𤭢𤭢"
        String s366 = "\uD852\uDF62\uD852\uDF62";
        // 返回代码单元数量 4
        System.out.println(s366.length());
        // 实际代码点数量 2
        System.out.println(s366.codePointCount(0, s366.length()));
        // 某处代码单元 ?，无法识别，因为双代码单元
        System.out.println(s366.charAt(0));
        // 想得到第i处代码点
        int index = s366.offsetByCodePoints(0, 1);
        // 2
        System.out.println(index);
        // 150370
        System.out.println(s366.codePointAt(2));

        // 不要使用char类型，太底层
        // 用codePoint遍历字符串
        int i = 0;
        while (i < s366.length()) {
            int cp = s366.codePointAt(i);
            if (Character.isSupplementaryCodePoint(cp)) {
                i += 2;
            } else {
                i += 1;
            }
            System.out.println("i++, i = " + i + ", cp = " + cp);
        }
        // 以下语句回退遍历
        i = s366.length();
        while (i > 0) {
            i--;
            if (Character.isSurrogate(s366.charAt(i))) {
                i--;
            }
            int cp = s366.codePointAt(i);
            System.out.println("i--, " + cp);
        }
    }
}
