package com.zhangzemiao.www.dropwizardDemo.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import javax.validation.constraints.NotEmpty;

/**
 * @Desc: Service Configuration
 * @author: wzhang
 * @date: 2021/1/14
 */
public class ServiceConfiguration extends Configuration {

    @JsonIgnore
    private final ApplicationEnvironment appEnvironment;

    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotEmpty
    @JsonProperty("template")
    private String template;

    @JsonProperty
    private boolean useSwagger;

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

    public boolean isUseSwagger() {
        return useSwagger;
    }

    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }

    public ApplicationEnvironment getAppEnvironment() {
        return appEnvironment;
    }

}
