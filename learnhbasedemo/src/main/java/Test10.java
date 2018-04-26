import com.alibaba.fastjson.JSON;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class Test10 {
    public static void main(String[] args) throws IOException {

        Connection.Response execute = Jsoup.connect("http://tieba.baidu.com/dc/common/tbs")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .cookie("BAIDUID", "-----:FG=1")
                .cookie("BDUSS", "-----")
                .execute();
        System.out.println(execute.body());
        String tbs = JSON.parseObject(execute.body()).getString("tbs");

        Connection.Response execute2 = Jsoup.connect("https://tieba.baidu.com/tbmall/onekeySignin1")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .data("ie", "utf-8")
                .data("tbs", tbs)
                .cookie("BAIDUID", "-----:FG=1")
                .cookie("BDUSS", "-----")
                .execute();
        System.out.println(execute2.body());
    }
}
