import org.apache.commons.lang.StringUtils;

public class Test7 {
    public static void main(String[] args) {
        String docChannel = "article_article12";
        String channel = StringUtils.removeStart(docChannel, "article_");

        System.out.println(docChannel);
        System.out.println(channel);
    }
}
