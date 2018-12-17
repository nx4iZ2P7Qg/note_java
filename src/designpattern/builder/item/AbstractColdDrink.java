package designpattern.builder.item;

import designpattern.builder.packing.Packing;
import designpattern.builder.packing.impl.Bottle;

/**
 * @author DF
 */
public abstract class AbstractColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 价钱
     *
     * @return
     */
    @Override
    public abstract float price();
}
