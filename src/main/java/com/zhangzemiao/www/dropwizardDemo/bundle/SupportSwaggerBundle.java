package com.zhangzemiao.www.dropwizardDemo.bundle;

import com.zhangzemiao.www.dropwizardDemo.configuration.ServiceConfiguration;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * @Desc: support swagger feature
 * @author: wzhang
 * @date: 2021/1/14
 */
public class SupportSwaggerBundle extends SwaggerBundle<ServiceConfiguration> {

    @Override
    protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ServiceConfiguration serviceConfiguration) {
        return serviceConfiguration.getSwaggerBundleConfiguration();
    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        // support swagger feature flag based on env conf
        if(configuration.isUseSwagger()){
            super.run(configuration, environment);
        }
    }
}
