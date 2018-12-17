package designpattern.prototype;

/**
 * 原型模式
 * <p>
 * 在保持性能的同时，复制对象
 * 此模式实现一个原型接口，此接口描述了创建当前对象的克隆对象，此模式用在直接创建对象比较消耗资源的地方
 * 比如，在代价很高的数据库查询后创建了一个对象，我们缓存它，下次查询时返回它的克隆，然后在需要的时候更新数据库，减少IO操作
 *
 * @author DF
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        AbstractShape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        AbstractShape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        AbstractShape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
