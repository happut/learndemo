import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.collections.MapUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;

public class Test7 {
    public static void main(String[] args) throws IOException, EncoderException {
     /*   String docChannel = "article_article12";
        String channel = StringUtils.removeStart(docChannel, "article_");
        System.out.println(docChannel);
        System.out.println(channel);


        OkHttpClient client = new OkHttpClient();
        Response execute = client.newCall(
                new Request.Builder().url("http://www.baidu.com").post(RequestBody.create(MediaType.parse("application/json"), "")).build()).execute();
        System.out.println(execute.body().string());
*/

        String urlPrefix = "http://xxxx:9999";


        Connection.Response response = Jsoup.connect(urlPrefix + "/auth/login")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .data("username", "admin", "password", "datacube123").execute();
        System.out.println(response.body().toString());

        String session = response.cookie("session");
        System.out.println(session);


        Connection.Response document = Jsoup.connect(urlPrefix + "/signature_auth/selectors/b4c4c175-9877-4f58-b8b6-bbcdcbaed1e8/rules")
                .method(Connection.Method.POST)
                .data("rule", "{\"name\":\"" + java.util.UUID.randomUUID().toString() + "\",\"judge\":{\"type\":0,\"conditions\":[{\"type\":\"URI\",\"operator\":\"match\",\"value\":\"\"}]},\"extractor\":{\"type\":1,\"extractions\":[]},\"handle\":{\"credentials\":{\"signame\":\"a\",\"secretkey\":\"aaaaaaa\"},\"code\":401,\"log\":true},\"enable\":false}")
                .cookie("session", session)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .execute();
        System.out.println(document.body().toString());

        Connection.Response document2 = Jsoup.connect(urlPrefix + "/signature_auth/sync")
                .method(Connection.Method.POST)
                .cookie("session", session)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .execute();
        System.out.println(document2.body().toString());


    }
}
