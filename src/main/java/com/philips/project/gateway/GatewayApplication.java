package com.philips.project.gateway;

import java.util.concurrent.TimeUnit;

import com.philips.project.gateway.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GatewayApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Bean
	public RestTemplate initRestTemplate()
	{
		return new RestTemplate();
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//	    // Register resource handler for images
//	    registry.addResourceHandler("/images/**").addResourceLocations("/resources/templates")
//	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
//	}
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
            registry.addResourceHandler("/**")
                 .addResourceLocations("classpath:/templates/");
    }

}
