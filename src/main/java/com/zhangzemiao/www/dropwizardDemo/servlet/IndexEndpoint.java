package com.zhangzemiao.www.dropwizardDemo.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Desc: default index page for micro service
 * @author: wzhang
 * @date: 2021/1/14
 */
public class IndexEndpoint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
        response.setStatus(200);
        response.setContentType("text/html;charset=UTF-8");

        final byte[] buffer = new byte[10240];
        try (
                InputStream input = getIndexHtml();
                OutputStream output = response.getOutputStream();
        ) {
            for (int length = 0; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
        }
    }

    private InputStream getIndexHtml(){
        return this.getClass().getClassLoader().getResourceAsStream("index.html");
    }

}
