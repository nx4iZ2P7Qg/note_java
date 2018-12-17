package concurrent;

import java.util.concurrent.*;

/**
 * Callable的范型
 *
 * @author DF
 */
public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        // 将Callable的实现传入FutureTask
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        int mainLoopTime = 100;
        for (int i = 0; i < mainLoopTime; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            // 只开启一个子线程，main线程不关闭
            if (i == 20) {
                ExecutorService executorService = Executors.newFixedThreadPool(1);
                executorService.execute(ft);
                executorService.shutdown();
            }
        }
        try {
            // ft.get()会等待FutureTask执行完毕后，才运行，这里会最后才打印出返回值
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() {
        int i = 0;
        int threadLoopTime = 100;
        for (; i < threadLoopTime; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
