package com.github.happut.learndemospringboot.study;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String demension = "platform\t操作系统，ios/android\n" +
                "model\t机型\n" +
                "channel_group\t渠道组\n" +
                "init_channel\t渠道号\n" +
                "bg\t打开方式\n" +
                "user_type\t核减作弊类型，不核减/核减自有作弊/核减数盟作弊\n" +
                "data_type\t数据类型，当日/首启/次日/三日/七日\n";

        JSONArray array = new JSONArray();
        JSONObject a = new JSONObject();
        a.put("name", "日期");
        a.put("key", "day");
        array.add(a);
        Arrays.stream(demension.split("\n")).forEach(element -> {
            String key = element.split("\t")[0];
            String name = element.split("\t")[1];
            JSONObject tmp = new JSONObject();
            tmp.put("name", name);
            tmp.put("key", key);
            array.add(tmp);
        });
        System.out.println(array
                .toJSONString());





        String measure = "newuser_uv\t新用户数\n" +
                "recommend_uv\t进入落地页曝光uv\n" +
                "first_read_uv\t首刷有阅读行为uv\n" +
                "browse_uv\t浏览uv\n" +
                "refresh_uv\t有刷新行为uv\n" +
                "read_uv\t图文阅读uv\n" +
                "video_uv\t播放视频uv\n" +
                "doc_recommend_uv\t图文曝光uv\n" +
                "video_recommend_uv\t视频曝光uv\n" +
                "doc_click_uv\t图文点击uv\n" +
                "video_click_uv\t视频点击uv\n" +
                "list_recommend_uv\t列表页曝光uv\n" +
                "list_browse_uv\t列表页浏览uv\n" +
                "list_read_uv\t列表页图文阅读uv\n" +
                "list_video_uv\t列表页视频播放uv\n" +
                "list_doc_recommend_uv\t列表页文章曝光uv\n" +
                "list_video_recommend_uv\t列表页视频曝光uv\n" +
                "list_doc_click_uv\t列表页图文点击uv\n" +
                "list_video_click_uv\t列表页视频点击uv\n" +
                "exp_num\t曝光pv\n" +
                "click_num\t点击pv\n" +
                "doc_exp_num\t图文曝光pv\n" +
                "doc_click_num\t图文点击pv\n" +
                "video_exp_num\t视频曝光pv\n" +
                "video_click_num\t视频点击pv\n" +
                "read_du\t图文阅读时长\n" +
                "video_du\t播放视频时长\n" +
                "read_num\t图文阅读次数\n" +
                "video_num\t视频播放次数\n" +
                "read_progress\t图文阅读进度\n" +
                "video_progress\t视频播放进度\n" +
                "doc_video_progress\t图文阅读和播放视频进度之和\n" +
                "app_progress\t总进度\n" +
                "up_refresh\t上拉刷新次数\n" +
                "down_refresh\t下拉刷新次数\n" +
                "browse_pv\t浏览pv\n" +
                "browse_dura\t浏览时长\n" +
                "duration\t停留时长\n" +
                "list_exp_num\t列表页曝光pv\n" +
                "list_click_num\t列表页点击pv\n" +
                "list_read_du\t列表页图文阅读时长\n" +
                "list_video_du\t列表页视频播放时长\n" +
                "list_read_num\t列表页图文阅读次数\n" +
                "list_video_num\t列表页视频播放次数\n" +
                "list_read_progress\t列表页图文阅读进度\n" +
                "list_video_progress\t列表页视频播放进度\n" +
                "list_doc_video_progress\t列表页图文阅读和视频播放总进度\n" +
                "list_kpi_pv\t列表页KPI\n" +
                "list_browse_dura\t列表页浏览时长\n" +
                "list_browse_pv\t列表页浏览pv\n" +
                "list_doc_exp_num\t列表页图文曝光次数\n" +
                "list_doc_click_num\t列表页图文点击次数\n" +
                "list_video_exp_num\t列表页视频曝光次数\n" +
                "list_video_click_num\t列表页视频点击pv\n" +
                "relative_exp_num\t相关推荐曝光pv\n" +
                "relative_click_num\t相关推荐点击pv\n" +
                "horizon_exp_num\t横滑相关推荐曝光数\n" +
                "horizon_click_num\t横滑相关推荐点击数\n" +
                "vertical_exp_num\t详情页曝光pv\n" +
                "vertical_click_num\t详情页点击pv\n" +
                "new_uv\t该日新用户数\n" +
                "part_newuv\t留存用户数\n";

        //[{"key":"newuser_uv","name":"abc","oper":"sum(newuser_uv)"}]
        JSONArray array2 = new JSONArray();
        Arrays.stream(measure.split("\n")).limit(35).forEach(element -> {
            String key = element.split("\t")[0];
            String name = element.split("\t")[1];
            JSONObject tmp = new JSONObject();
            tmp.put("name", name);
            tmp.put("key", key);
            tmp.put("oper","sum("+key+")");
            array2.add(tmp);
        });
        System.out.println(array2
                .toJSONString());
    }


}
