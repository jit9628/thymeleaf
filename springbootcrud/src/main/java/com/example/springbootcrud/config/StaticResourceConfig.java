//package com.example.springbootcrud.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class StaticResourceConfig  implements WebMvcConfigurer{
//
//	public StaticResourceConfig()  {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	  if (!registry.hasMappingForPattern("/assets/**")) {
//	     registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//	  }
//	}
//
//}
