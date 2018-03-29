import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import okhttp3.*;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.collections.MapUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


/*

        Connection.Response document = Jsoup.connect(urlPrefix + "/signature_auth/selectors/b4c4c175-9877-4f58-b8b6-bbcdcbaed1e8/rules")
                .method(Connection.Method.POST)
                .data("rule", "{\"name\":\"" + "wangfei" + "\",\"judge\":{\"type\":0,\"conditions\":[{\"type\":\"URI\",\"operator\":\"match\",\"value\":\"\"}]},\"extractor\":{\"type\":1,\"extractions\":[]},\"handle\":{\"credentials\":{\"signame\":\"a\",\"secretkey\":\"aaaaaaa\"},\"code\":401,\"log\":true},\"enable\":false}")
                .cookie("session", session)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .execute();
        System.out.println(document.body().toString());
*/

        Response document = new OkHttpClient().newCall(new Request.Builder()
                .url("http://xxxxxxxxxxxxx:7777/signature_auth/selectors/b4c4c175-9877-4f58-b8b6-bbcdcbaed1e8/rules")
                .header("Authorization", "d2VibG9nOndlYmxvZw==")
                .post(new FormBody.Builder().add("rule", "{\"name\":\"" + "wangfei" + "\",\"judge\":{\"type\":0,\"conditions\":[{\"type\":\"URI\",\"operator\":\"match\",\"value\":\"\"}]},\"extractor\":{\"type\":1,\"extractions\":[]},\"handle\":{\"credentials\":{\"signame\":\"a\",\"secretkey\":\"aaaaaaa\"},\"code\":401,\"log\":true},\"enable\":false}").build())
                .build()).execute();
        System.out.println(document.body().string());


        Response selectors = new OkHttpClient().newCall(new Request.Builder()
                .url("http://xxxxxxxxxxxxx:7777/signature_auth/selectors/b4c4c175-9877-4f58-b8b6-bbcdcbaed1e8/rules")
                .header("Authorization", "d2VibG9nOndlYmxvZw==")
                .get()
                .build()).execute();

        String result = selectors.body().string();
        System.out.println(result);
        List<JSONObject> eval = (List<JSONObject>) JSONPath.eval(JSON.parse(result), "$.data.rules[name='wangfei']");


        if (!eval.isEmpty()) {

            System.out.println(eval.get(0).getString("id"));

            OkHttpClient httpClient = new OkHttpClient();
            RequestBody requestBody = new FormBody.Builder().add("rule_id", eval.get(0).getString("id")).build();
            Request request = new Request.Builder()
                    .url("http://xxxxxxxxxxxxx:7777/signature_auth/selectors/b4c4c175-9877-4f58-b8b6-bbcdcbaed1e8/rules")
                    .header("Authorization", "d2VibG9nOndlYmxvZw==")
                    .delete(requestBody)
                    .build();
            Response responseOK = httpClient.newCall(request).execute();
            System.out.println(responseOK.body().string());
        }





    }
}
