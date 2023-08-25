import java.util.Random;

public class ThreadLocalFunc implements Runnable{
    private static final ThreadLocal<Integer> ints = ThreadLocal.withInitial(() -> 0);
    public static void main(String[] args) {
        ThreadLocalFunc tlf = new ThreadLocalFunc();
        Thread t1 = new Thread(tlf);
        Thread t2 = new Thread(tlf);
        Thread t3 = new Thread(tlf);
        t1.start();
        t2.start();
        t3.start();
    }
    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName() + "    " + ints.get());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ints.set(new Random().nextInt(100));

        System.out.println("Thread Name= "+Thread.currentThread().getName() + "    " + ints.get());
    }
}
