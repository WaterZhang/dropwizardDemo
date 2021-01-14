package com.zhangzemiao.www.dropwizardDemo.resources;

import com.codahale.metrics.annotation.Timed;
import com.zhangzemiao.www.dropwizardDemo.domain.valueobject.Saying;
import io.swagger.annotations.Api;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @Desc: Test Resources
 * @author: wzhang
 * @date: 2021/1/14
 */

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Api("Hello World API")
public class HelloWorldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name){
        final String value = String.format(template, name.orElse(this.defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

}
