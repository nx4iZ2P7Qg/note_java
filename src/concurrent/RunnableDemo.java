package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 实现Runnable类，重写run()方法
 * 实例用start()方法启用线程
 *
 * @author DF
 */
public class RunnableDemo implements Runnable {

    /**
     * 用来分辨是哪个实例在运行
     */
    private int i;

    private RunnableDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        // 输出的结果无序，但正确
        System.out.println("MyThread " + i + ".run()");
    }

    public static void main(String[] args) {
        RunnableDemo myT1 = new RunnableDemo(1);
        RunnableDemo myT2 = new RunnableDemo(2);
        RunnableDemo myT3 = new RunnableDemo(3);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                20,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(2),
                namedThreadFactory
        );
        executorService.execute(myT1);
        executorService.execute(myT2);
        executorService.execute(myT3);
        executorService.shutdown();
    }
}

