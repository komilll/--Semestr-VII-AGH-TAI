package pl.agh.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        int randomInt = ThreadLocalRandom.current().nextInt(1, 100);
        if ((randomInt % 2) == 0) {
            return "Hello World";
        } else {
            throw new RuntimeException("Random exception: " + randomInt);
        }
    }

    @GetMapping("/random-number")
    public Integer randomNumber() {
        return ThreadLocalRandom.current().nextInt(-100, 100);
    }
}
