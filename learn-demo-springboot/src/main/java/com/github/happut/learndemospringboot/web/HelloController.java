package com.github.happut.learndemospringboot.web;

import com.alibaba.fastjson.JSON;
import com.github.happut.learndemospringboot.respository.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.histogram.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Controller
public class HelloController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/hello")
    public String index() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String forObject = restTemplate.getForObject("http://123.58.179.241:7777/stat/status", String.class);
        return "Hello World" + forObject;
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/query")
    @ResponseBody
    public String test() {

        //QueryBuilders.rangeQuery("time_local").from(DateTime.now().minusHours(12).toDate().toString()).to(new Date())
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("interface.keyword", "/api/dataQuery/ce3e38da2c724624bcdaa1e4a078f339"))
                .must(QueryBuilders.rangeQuery("@timestamp").gt(DateTime.now().minusHours(24)).lt(DateTime.now()));
        System.out.println(query.toString());

        DateHistogramAggregationBuilder agg = AggregationBuilders.dateHistogram("groupDate").field("@timestamp").dateHistogramInterval(DateHistogramInterval.HOUR).order(Histogram.Order.KEY_DESC);
        System.out.println(agg.toString());

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withIndices("filebeat-orange-2018.09")
                .withTypes("orange")
                .addAggregation(agg)
                .build();
//        System.out.println(elasticsearchTemplate.count(searchQuery));


        System.out.println(JSON.toJSON(searchQuery));
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, SearchResponse::getAggregations);

        Map<String, Long> map = new LinkedHashMap<>();
        aggregations.asMap().forEach((key, aggregation) -> {
            if (aggregation == null) {
                return;
            }

            System.out.println(key);
            InternalDateHistogram modelTerms = (InternalDateHistogram) aggregation;
            System.out.println(modelTerms.getBuckets().size());
            for (InternalDateHistogram.Bucket actionTypeBucket : modelTerms.getBuckets()) {
                System.out.println(actionTypeBucket.getKey().getClass().getSimpleName());
                map.put(((DateTime) actionTypeBucket.getKey()).toString("yyyy-MM-dd HH:mm:ss", Locale.CHINA), actionTypeBucket.getDocCount());


            }
        });


        return JSON.toJSON(map).toString();
    }

    public static void main(String[] args) {
        System.out.println(DateTime.parse("2018-09-17T11:00:00.000Z"));
    }
}
