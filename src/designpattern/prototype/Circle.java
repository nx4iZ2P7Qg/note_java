package designpattern.prototype;

/**
 * @author DF
 */
public class Circle extends AbstractShape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
