import com.alibaba.fastjson.JSON;
        import com.alibaba.fastjson.JSONObject;

public class Test8 {
    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject("{\"cube\":\"\",\"sql\":\"\"}");


        System.out.println(JSON.toJSONString(jsonObject, true));

    }
}
