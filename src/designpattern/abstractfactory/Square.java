package designpattern.abstractfactory;

/**
 * @author DF
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
