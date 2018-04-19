package com.WS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Because Angular is a single page application and Apache Tomcat didn't get the memo, this forwards all non-static
     * (html, css, js, etc) paths to the root path (/) so that Angular can take it from there.
     *
     * @return address to forward to
     */
    @GetMapping(value = "/**/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
}
