package com.github.happut.learndemospringboot.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "filebeat-orange-2018.09",type = "orange")
@Getter
@Setter
public class GoodsInfo implements Serializable {
    private Long id;
    private String source;
    private String host;
    private String interfaceName;
}