package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁是用来保护共享资源的工具，共享资源可能是任何东西，数据库、文件系统、质数生成器
 * 锁在1.5后进入jdk，作为synchronized关键字的另一种选择
 * java.util.concurrent.locks.Lock是一个接口，其实现类有ReentrantLock，ReentrantReadWriteLock
 *
 * @author DF
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {

        final Counter c = new Counter(new ReentrantLock());

        Runnable r = () ->
                System.out.printf("Count at thread %s is %d \n", Thread.currentThread().getName(), c.getCount());

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                20,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(2),
                namedThreadFactory
        );
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);
        executorService.shutdown();
    }
}

class Counter {
    private Lock lock;
    private Integer count = 0;

    Counter(Lock lock) {
        this.lock = lock;
    }

    public Integer getCount() {
        lock.lock();
        try {
            count++;
            return count;
        } finally {
            lock.unlock();
        }
    }
}