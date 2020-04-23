package com.jaimanandjain.tarne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TarneApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(TarneApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(TarneApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String sayHello(){
        return "Let's build some epic things !! Tomcat Started";
    }


}
