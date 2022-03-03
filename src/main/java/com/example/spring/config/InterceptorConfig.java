package com.example.spring.config;

import com.example.spring.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry) {
    interceptorRegistry.addInterceptor(new UserLoginInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/", "/index", "/loginPage", "/loginStatus", "/login", "/wx/**", "/files/**");
  }

}
