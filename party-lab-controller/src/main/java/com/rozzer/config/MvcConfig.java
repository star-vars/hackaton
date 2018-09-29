package com.rozzer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("static:/index.html").setViewName("index");
        registry.addViewController("static:/index.html").setViewName("index");
        registry.addViewController("static:/login.html").setViewName("login");
    }

}
