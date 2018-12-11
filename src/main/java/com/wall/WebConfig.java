package com.wall;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Value("${server.contextPath}")
    private String url;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/nn").setViewName("forward:/index.html");
	}
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("**/assets/**")
                .addResourceLocations("classpath:/static/assets");
        registry.addResourceHandler("/*.html").addResourceLocations("classpath:/static/");
    }
    

}