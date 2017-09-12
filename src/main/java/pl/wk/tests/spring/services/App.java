package pl.wk.tests.spring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.wk.tests.spring.services.config.TestConfiguration;
import pl.wk.tests.spring.services.model.Quote;

/**
 * Created by Fumik on 4/30/2017.
 */
@SpringBootApplication
public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("Starting app!!!");
        SpringApplication.run(App.class, args);
//        RestTemplate rs = new RestTemplate();
//        App app = new App();
//        for(int i = 0; i < 1; ++i) {
//            //Quote quote = rs.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//
//            ResponseEntity<Quote> entity = rs.getForEntity("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//
//            System.out.println(entity);
//            //System.out.println(quote);
//        }
    }
}
