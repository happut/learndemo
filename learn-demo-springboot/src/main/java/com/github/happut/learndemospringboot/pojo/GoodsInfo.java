package com.github.happut.learndemospringboot.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "testgoods",type = "goods")
@Getter
@Setter
public class GoodsInfo implements Serializable {
    private Long id;
    private String name;
    private String description;
}