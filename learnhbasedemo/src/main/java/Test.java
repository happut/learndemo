import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws IOException {
        Stopwatch stopWatch = Stopwatch.createStarted();

        Element body = Jsoup.connect("https://movie.douban.com/subject/26665065/output_card").get().body();

        String vote = body.select(".rating_sum > .rating_people > span").first().text();
        System.out.println(vote);

        Elements ratios = body.select(".ratings-on-weight > .item");
        Double sum = 0D;
        for (Element e : ratios) {
            String star = e.select(".starstop").first().text().replace("星", "");
            String ratio = e.select(".rating_per").first().text().replace("%", "");
            sum += Integer.valueOf(star) * Double.valueOf(ratio);
        }
        System.out.println(sum * 2 / 100.0);

        stopWatch.stop();
        System.out.println(stopWatch.elapsed(TimeUnit.MILLISECONDS) / 1000.0);

        java.util.UUID.randomUUID().toString().replace("-", "");


        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture explosion = service.submit(new Callable() {
            public String call() {
                return "test";
            }
        });
        Futures.addCallback(explosion, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
        service.shutdown();

    }
}
