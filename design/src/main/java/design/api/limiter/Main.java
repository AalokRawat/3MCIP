package design.api.limiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApiRateLimitManager apiRateLimitManager = new ApiRateLimitManager(
                new Configuration(5, 1, TimeUnit.MINUTES), Configuration.ApiLimitAlgorithmType.LEAKING_BUCKET);

        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int j=0; j<100; j++) {
            service.execute(() -> {
                for(int i=0; i<10; i++) {
                    System.out.println(apiRateLimitManager.execute("user"+i));
                }
            });
        }

        Thread.sleep(30000);

        for(int j=0; j<100; j++) {
            service.execute(() -> {
                for(int i=0; i<10; i++) {
                    System.out.println(apiRateLimitManager.execute("user"+i));
                }
            });
        }
    }
}
