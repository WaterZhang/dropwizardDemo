package com.zhangzemiao.www.dropwizardDemo.bundle;

import com.google.common.collect.ImmutableMap;
import com.zhangzemiao.www.dropwizardDemo.configuration.ServiceConfiguration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

/**
 * @Desc: cross origin filter
 * @author: wzhang
 * @date: 2021/1/14
 */
public class CrossOriginFilterBundle implements ConfiguredBundle<ServiceConfiguration> {

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        final FilterRegistration.Dynamic filter =
                environment.servlets().addFilter(
                        CrossOriginFilter.class.getSimpleName(), CrossOriginFilter.class);
        filter.setInitParameters(ImmutableMap.of(CrossOriginFilter.ALLOWED_ORIGINS_PARAM,
                "https://xxx.com, "
                        + "http://doco, "
                        // test
                        + "http://test.xxx.com, "
                        // sandbox
                        + "http://localhost:8080",
                // local
                CrossOriginFilter.ALLOW_CREDENTIALS_PARAM,
                "true",
                CrossOriginFilter.ALLOWED_HEADERS_PARAM,
                "*",
                CrossOriginFilter.ALLOWED_METHODS_PARAM,
                "*",
                CrossOriginFilter.EXPOSED_HEADERS_PARAM,
                "*"));
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "*", "/swagger.json");
    }
}
