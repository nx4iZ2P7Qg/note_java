package designpattern.prototype;

/**
 * @author DF
 */
public class Rectangle extends AbstractShape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
