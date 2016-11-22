package io.rankedup.controllers;

import io.rankedup.EnvironmentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@RestController
public class HomeController {

    Client client = ClientBuilder.newClient();

    @Autowired
    private EnvironmentConfig config;

    @Value("${environment.url}")
    private String url;


    /**
     * Showing how to consume properties via @Value and how to use beans to strictly manage multiple properties via
     * getters and setters
     *
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    private String welcome() {
        return String.format("Welcome %s, the url for this environment is: %s", config.getName(), url);
    }

    /**
     * Showing how to consume an external API
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/character")
    String character() {
        String server = "stormreaver";
        String locale = "en_US";
        String apiKey = "4b824btmudfvcp4k6xsz4eupp944kynk";
        String baseUrl = "https://us.api.battle.net/wow/";
        String character = "Razghul";

        WebTarget target = client.target(baseUrl + "character").path(server).path(character).
                queryParam("locale", locale).queryParam("apiKey", apiKey);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        return response.readEntity(String.class);
    }
}
