package com.zhangzemiao.www.dropwizardDemo.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Desc: Saying Value Object
 * @author: wzhang
 * @date: 2021/1/14
 */
public class Saying {

    @JsonProperty
    private long id;
    @JsonProperty
    private String content;

    public Saying(){
        // Empty Constructor
    }

    public Saying(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
