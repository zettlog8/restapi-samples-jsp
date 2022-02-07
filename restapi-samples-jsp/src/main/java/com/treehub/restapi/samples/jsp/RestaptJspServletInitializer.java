/**
 * 
 */
package com.treehub.restapi.samples.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author hh.lee
 *
 */
@SpringBootApplication
public class RestaptJspServletInitializer extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RestaptJspServletInitializer.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RestaptJspServletInitializer.class);
    }
}
