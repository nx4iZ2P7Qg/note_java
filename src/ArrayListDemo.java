import java.util.ArrayList;

/**
 * @author DF
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.trimToSize();
        // ArrayList<Integer>的效率远远低于int[]，因此，在考虑操作方便时，应该用它构造小型集合
    }
}
