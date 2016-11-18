package io.rankedup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RankedupApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankedupApplication.class, args);
    }
}
