package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 参考网站
 * https://javarevisited.blogspot.sg/2012/07/countdownlatch-example-in-java.html
 * <p>
 * 从java5开始包含的类，在服务端中经常用到，和CyclicBarrier, Semaphore, ConcurrentHashMap and BlockingQueue一样，
 * 位于java.util.concurrent包中
 * CountDownLatch的功能可以用wait()和notify()来实现，不过要复杂一些
 * <p>
 * 此类的缺点是当count down到0后，实例就没法再使用
 * 有需求的地方要替换成CyclicBarrier的方法
 * <p>
 * Java program to demonstrate How to use CountDownLatch in Java. CountDownLatch is
 * useful if you want to start main processing thread once its dependency is completed
 * as illustrated in this CountDownLatch Example
 * <p>
 * Java程序演示如何使用CountDownLatch
 * CountDownLatch在如下情形能有效发挥作用：主进程依赖线程服务开启后才能开始运行
 *
 * @author DF
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                20,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(2),
                namedThreadFactory
        );
        executorService.execute(new Service("CacheService", 1000, latch));
        executorService.execute(new Service("AlertService", 1000, latch));
        executorService.execute(new Service("ValidationService", 1000, latch));
        executorService.shutdown();

        // application should not start processing any thread until all service is up
        // and ready to do there job.
        // Countdown latch is idle choice here, main thread will start with count 3
        // and wait until count reaches zero. each thread once up and read will do
        // a count down. this will ensure that main thread is not started processing
        // until all services is up.

        //count is 3 since we have 3 Threads (Services)

        try {
            latch.await();  //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */
class Service implements Runnable {
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

    Service(String name, int timeToStart, CountDownLatch latch) {
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
}