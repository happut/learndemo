import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
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

        java.util.UUID.randomUUID().toString().replace("-","");
    }
}
