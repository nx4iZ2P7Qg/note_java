import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DF
 */
public class LogDemo {

    private static final Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(1000);
                new LogDemo().test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void test() {
        String message = "hi LogDemo";
        logger.error("slf4j + log4j2: message = {}", message);
    }
}
