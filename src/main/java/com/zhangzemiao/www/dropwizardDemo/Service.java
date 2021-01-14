package com.zhangzemiao.www.dropwizardDemo;

import com.zhangzemiao.www.dropwizardDemo.bundle.CrossOriginFilterBundle;
import com.zhangzemiao.www.dropwizardDemo.bundle.SupportSwaggerBundle;
import com.zhangzemiao.www.dropwizardDemo.configuration.ServiceConfiguration;
import com.zhangzemiao.www.dropwizardDemo.resources.HelloWorldResource;
import com.zhangzemiao.www.dropwizardDemo.servlet.IndexEndpoint;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @Desc: main class for APP
 * @author: wzhang
 * @date: 2021/1/14
 */
public class Service extends Application<ServiceConfiguration> {

    public static void main(String[] args) throws Exception{
        new Service().run(args);
    }

    @Override
    public String getName() {
        return "haha";
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        // swagger
        bootstrap.addBundle(new SupportSwaggerBundle());
        bootstrap.addBundle(new CrossOriginFilterBundle());
    }

    @Override
    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {
        final HelloWorldResource HelloResource = new HelloWorldResource(
                serviceConfiguration.getTemplate(),
                serviceConfiguration.getDefaultName()
        );

        environment.jersey().register(HelloResource);
        //default index page support
        environment.getApplicationContext().addServlet(new ServletHolder(new IndexEndpoint()), "");
    }

}
