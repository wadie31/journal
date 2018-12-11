package com.wall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.wall.dao")
public class Application extends SpringBootServletInitializer {
//
	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
	        return springApplicationBuilder
	                .sources(Application.class);
	    }

	    public static void main(String[] args) {

	        SpringApplicationBuilder springApplicationBuilder = (SpringApplicationBuilder) new SpringApplicationBuilder(Application.class)
	                .sources(Application.class)
	                .run(args);
	    }
}