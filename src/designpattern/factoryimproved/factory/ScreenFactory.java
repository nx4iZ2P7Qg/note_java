package designpattern.factoryimproved.factory;

import designpattern.factoryimproved.product.Product;
import designpattern.factoryimproved.product.ScreenProduct;

/**
 * @author DF
 */
public class ScreenFactory implements Factory {
    @Override
    public Product create() {
        return new ScreenProduct();
    }
}
