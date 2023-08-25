import java.util.concurrent.*;

public class ThreadPoolFunc {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        executor.submit(futureTask);
        if (!futureTask.isDone()) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task is not finished");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int result = 0;
        try {
            result = futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result is " + result);
        executor.shutdown();
    }
    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " is running");
            int result = 0;
            for (int i = 0; i <= 100; i++) {
                result += i;
            }
            Thread.sleep(1000);
            return result;
        }
    }
}
