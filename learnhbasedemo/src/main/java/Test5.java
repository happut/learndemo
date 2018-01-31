import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test5 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            final int finalI = i;
            es.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(10000);
                    System.out.println(finalI + "进程运行完毕");
                    return null;

                }
            });
        }

        System.out.println("main运行完毕");
    }
}
