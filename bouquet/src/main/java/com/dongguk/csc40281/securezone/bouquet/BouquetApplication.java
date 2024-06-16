package com.dongguk.csc40281.securezone.bouquet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.system.DiskSpaceHealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import java.io.File;

@SpringBootApplication
public class BouquetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BouquetApplication.class, args);
    }

    @Bean
    public HealthIndicator diskSpaceHealthIndicator() {
        return new DiskSpaceHealthIndicator(new File("/logs"), DataSize.ofMegabytes(10));
    }

}

