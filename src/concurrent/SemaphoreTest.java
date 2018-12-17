package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * https://javarevisited.blogspot.sg/2012/05/counting-semaphore-example-in-java-5.html
 * 参考
 * <p>
 * 计数信号量
 * 给资源加上一个边界
 * 访问共享资源前，要获得一个使用权，如果使得权已经耗尽，新的线程只有等待到其他线程释放
 * 这个同步工具非常适合实现生产者消费者模式，或者边界池，或者线程池，数据库连接池
 * <p>
 * 常用情形
 * 规划数据库连接线程池，如果已经达到最大连接数，新线程只能等待，并且在拿到使用权后立即连接
 * 设定collection的边界，使得collection的大小固定
 * <p>
 * 注意点
 * 多个tryAquire()方法重载
 * acquireUninterruptibly()，阻止其他请求，等待使用权(?)
 *
 * @author DF
 */
public class SemaphoreTest {
    /**
     * 信号量，总量
     */
    private Semaphore binary = new Semaphore(1);

    public static void main(String[] args) {
        final SemaphoreTest test = new SemaphoreTest();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                20,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(2),
                namedThreadFactory
        );
        executorService.execute(test::mutualExclusion);
        executorService.execute(test::mutualExclusion);
        executorService.shutdown();
    }

    private void mutualExclusion() {
        try {
            binary.acquire();

            // mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            // 线程获得资源未释放，进入休眠，其他线程无法获得资源
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }

}
