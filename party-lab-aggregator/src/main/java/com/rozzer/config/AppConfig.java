package com.rozzer.config;

import com.rozzer.spring.DBManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DBManagerFactory transferService() {
        return new DBManagerFactory();
    }
}
