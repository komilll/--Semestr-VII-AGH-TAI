package pl.agh.servicedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDatabaseApplication.class, args);
    }

}
