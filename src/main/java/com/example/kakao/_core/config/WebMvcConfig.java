package com.example.kakao._core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //  핸들러에서 파일 경로를 따로 지정해주므로 생긴 이슈 - 이미지 로드 이슈 해결 완료

//    @Value("${file.path}")
//    private String filePath;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//        registry.addResourceHandler("/images/**")
//                .addResourceLocations("file:" + filePath)
//                .setCachePeriod(60 * 60)
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver());
//    }
}
