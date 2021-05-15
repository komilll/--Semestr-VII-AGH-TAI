package pl.agh.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        int randomInt = ThreadLocalRandom.current().nextInt(1, 100);

        if ((randomInt % 5) == 0) {
            throw new IllegalArgumentException("Illegal argument: " + randomInt);
        } else if ((randomInt % 3) == 0) {
            throw new IllegalStateException("Illegal state: " + randomInt);
        } else if ((randomInt % 2) == 0) {
            throw new ArithmeticException("Wrong number: " + randomInt);
        } else {
            return "Hello World";
        }
    }

    @GetMapping("/random-number")
    public Integer randomNumber() {
        return ThreadLocalRandom.current().nextInt(-100, 100);
    }
}
