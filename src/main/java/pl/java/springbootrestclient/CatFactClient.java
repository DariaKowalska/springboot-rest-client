package pl.java.springbootrestclient;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.java.springbootrestclient.model.CatFact;


@Service
public class CatFactClient {

    @EventListener(ApplicationReadyEvent.class)
    public String getCatFactFromApi() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CatFact> exchange = restTemplate.exchange(
                "https://cat-fact.herokuapp.com/facts/random",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                CatFact.class);
        System.out.println(exchange.getBody());
        return "";
    }

}
