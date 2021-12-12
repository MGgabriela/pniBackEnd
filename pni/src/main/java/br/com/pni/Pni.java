package br.com.pni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan
@EnableSpringDataWebSupport
public class Pni extends SpringBootServletInitializer{

	Logger log = LoggerFactory.getLogger(Pni.class);
	
	public static void main(String[] args) {		
		SpringApplication.run(Pni.class, args);
		System.out.println("chegou main");
		 
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Pni.class);
	}
	
}
