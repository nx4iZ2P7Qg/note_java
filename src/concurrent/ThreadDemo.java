package concurrent;

/**
 * 继承Thread类，重写run()方法
 * 实例用start()方法启用线程
 *
 * @author DF
 */
public class ThreadDemo extends Thread {

    /**
     * 用来分辨是哪个实例在运行
     */
    private int i;

    private ThreadDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        // 输出的结果无序，但正确
        System.out.println("MyThread " + i + ".run()");
    }

    public static void main(String[] args) {
        ThreadDemo myT1 = new ThreadDemo(1);
        ThreadDemo myT2 = new ThreadDemo(2);
        ThreadDemo myT3 = new ThreadDemo(3);
        myT1.start();
        myT2.start();
        myT3.start();
    }
}

