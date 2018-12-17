package designpattern.prototype;

/**
 * @author DF
 */
public abstract class AbstractShape implements Cloneable {
    private String id;
    protected String type;

    /**
     * 绘制
     */
    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
