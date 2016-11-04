package io.rankedup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @RequestMapping("/auction")
    String auction() {
        Client client = ClientBuilder.newClient();
        String server = "stormreaver";
        String locale = "en_US";
        String apiKey = "4b824btmudfvcp4k6xsz4eupp944kynk";

        WebTarget target = client.target("https://us.api.battle.net/wow/auction/data").path(server).queryParam("locale", locale).queryParam("apiKey", apiKey);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        String responseEntity = response.readEntity(String.class);
        return responseEntity;
    }

}
