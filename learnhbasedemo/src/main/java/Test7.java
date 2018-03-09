import okhttp3.*;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

public class Test7 {
    public static void main(String[] args) throws IOException {
        String docChannel = "article_article12";
        String channel = StringUtils.removeStart(docChannel, "article_");
        System.out.println(docChannel);
        System.out.println(channel);


        OkHttpClient client = new OkHttpClient();
        Request r = new Request.Builder().url("http://www.baidu.com").post(RequestBody.create(MediaType.parse("application/json"), "")).build();
        Response execute = client.newCall(r).execute();
        System.out.println(execute.body().string());
    }
}
