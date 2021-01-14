package com.zhangzemiao.www.dropwizardDemo.configuration;

import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * @Desc: Application Env
 * @author: wzhang
 * @date: 2021/1/14
 */
public class ApplicationEnvironment {

    public static final String APPLICATION_NAME = "application.name";
    public static final String APPLICATION_ENVIRONMENT = "application.environment";
    public static final String APPLICATION_HOME = "application.home";

    private final String applicationName;
    private final String applicationHome;
    private final String applicationEnvironment;

    public ApplicationEnvironment(){
        this(System.getProperties());
    }

    public ApplicationEnvironment(Properties properties){
        Validate.notNull(properties);

        this.applicationName = properties.getProperty(APPLICATION_NAME);
        this.applicationEnvironment = properties.getProperty(APPLICATION_ENVIRONMENT);
        this.applicationHome = properties.getProperty(APPLICATION_HOME);

        Validate.isTrue(StringUtils.isNotBlank(this.applicationName), APPLICATION_NAME + " is a required property");
        Validate.isTrue(StringUtils.isNotBlank(this.applicationHome), APPLICATION_HOME + " is a required property");
        Validate.isTrue(StringUtils.isNotBlank(this.applicationEnvironment), APPLICATION_ENVIRONMENT + " is a required property");
    }

    public boolean isProduction() {
        return getApplicationEnvironment().equals("prod");
    }

    public boolean isDevelopment() {
        return getApplicationEnvironment().equals("dev");
    }

    public boolean isTest() {
        return getApplicationEnvironment().equals("test");
    }


    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationHome() {
        return applicationHome;
    }

    public String getApplicationEnvironment() {
        return applicationEnvironment;
    }
}
