package com.zhangzemiao.www.dropwizardDemo.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotEmpty;

/**
 * @Desc: Service Configuration
 * @author: wzhang
 * @date: 2021/1/14
 */
public class ServiceConfiguration extends Configuration {

    @JsonIgnore
    private final ApplicationEnvironment appEnvironment;

    @NotEmpty
    @JsonProperty("template")
    private String template;

    @NotEmpty
    @JsonProperty("defaultName")
    private String defaultName = "Stranger";


    public ServiceConfiguration(){
        this.appEnvironment = new ApplicationEnvironment();
    }

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public ApplicationEnvironment getAppEnvironment() {
        return appEnvironment;
    }
}
