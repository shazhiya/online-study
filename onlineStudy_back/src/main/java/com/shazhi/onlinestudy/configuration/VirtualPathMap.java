package com.shazhi.onlinestudy.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class VirtualPathMap  implements WebMvcConfigurer {
    @Value("${file.save.path}")
    String path;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+ path+"img/");
        registry.addResourceHandler("/headIco/**").addResourceLocations("file:"+ path+"headIco/");
        registry.addResourceHandler("/courseCover/**").addResourceLocations("file:"+ path+"courseCover/");
        registry.addResourceHandler("/courseware/**").addResourceLocations("file:"+ path+"courseware/");
    }
}
