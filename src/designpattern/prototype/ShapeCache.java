package designpattern.prototype;

import java.util.Hashtable;

/**
 * @author DF
 */
public class ShapeCache {
    private static Hashtable<String, AbstractShape> shapeMap = new Hashtable<>();

    public static AbstractShape getShape(String shapeId) {
        AbstractShape cachedShape = shapeMap.get(shapeId);
        return (AbstractShape) cachedShape.clone();
    }

    // 对每个Shape查询数据库创建Shape
    // shapeMap.put(shapeKey, shape);
    // 比如，添加3个shapes

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
