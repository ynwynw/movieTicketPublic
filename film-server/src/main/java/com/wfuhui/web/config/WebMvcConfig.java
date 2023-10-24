package com.wfuhui.web.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wfuhui.web.interceptor.AuthorizationInterceptor;

/**
 * MVC配置
 *
 * @author lzl
 * @email 931708230@qq.com
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${fileupload.filepath}")
    String filepath;
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry)
//    {
//        /** 文件上传路径 */
//        registry.addResourceHandler("/profile/**").addResourceLocations("file:" + filepath);
//    }

}