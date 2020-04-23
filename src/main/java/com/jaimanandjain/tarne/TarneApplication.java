package com.jaimanandjain.tarne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TarneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarneApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String sayHello(){
        return "Let's build some epic things !!";
    }


}
