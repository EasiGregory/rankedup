package io.rankedup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RankedupApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankedupApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Home | Spring Boot";
    }

    @RequestMapping("/boot")
    String boot() {
        return "Boot | Spring Boot";
    }

    @RequestMapping("/test")
    String test() {
        return "Test | Spring Boot";
    }
}
