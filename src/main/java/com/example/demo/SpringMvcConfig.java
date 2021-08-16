package com.example.demo;

import com.example.demo.interceptor.ActionInterceptor;
import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Resource
    LoginInterceptor loginInterceptor;

    @Resource
    ActionInterceptor actionInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        String[] swaggerExcludes=new String[]{"/error/**","/swagger-ui.html/**","/swagger-resources/**","/webjars/**","/v2/**","/doc.html/**","/null/**"};

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(

                        "/user/login"


                )
                .excludePathPatterns("/rest/login.do/info")
        .excludePathPatterns( swaggerExcludes);

        registry.addInterceptor(actionInterceptor)
                .addPathPatterns(
                        "/*/save",
                        "/*/delete/**",
                        "/*/reset-password");
    }
}
