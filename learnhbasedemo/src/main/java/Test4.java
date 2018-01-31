import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {

        JSONObject json = JSON.parseObject("{\n" +
                "    \"type\": \"dataQuery\",\n" +
                "    \"queryEngine\": \"impalaDataEngine\",\n" +
                "    \"queryBody\": {\n" +
                "        \"sql\": \"select docid, tid, totalshare, totalgentie FROM adm_recommend_groupitem_docid_share_tie_day where day='@day@' AND docid in (@tids@)\"\n" +
                "    },\n" +
                "    \"variables\": [{\n" +
                "            \"id\": \"day\",\n" +
                "            \"type\": \"string\",\n" +
                "            \"allowNull\": \"true\",\n" +
                "            \"default\": \"${dataop.date.yyyyMMdd.-1}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"tids\",\n" +
                "            \"type\": \"string\",\n" +
                "            \"multiple\": \"true\",\n" +
                "            \"splitStr\": \",\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");

        JSONArray test = (JSONArray) JSONPath.eval(json, "$.variables");
        for (Object j : test) {
            System.out.println(JSONPath.eval(j, "$.default"));
        }

        System.out.println(JSONPath.eval(json, "$.variables[?(default)]"));


    }
}
