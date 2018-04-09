package com.github.happut.learndemospringboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @RequestMapping("/hello")
    public String index() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String forObject = restTemplate.getForObject("http://123.58.179.241:7777/stat/status",String.class);
        return "Hello World" + forObject;
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
