package com.mudigal.two;

import com.mudigal.two.service.NameValueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Vijayendra Mudigal
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTwoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(NameValueService nameValueService) {
        return args -> {
            generateNameValue(nameValueService);
        };
    }

    private void generateNameValue(NameValueService nameValueService) {
        nameValueService.generateUUID();
    }

}
