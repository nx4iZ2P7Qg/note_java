package designpattern.prototype;

/**
 * @author DF
 */
public class Square extends AbstractShape {
    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
