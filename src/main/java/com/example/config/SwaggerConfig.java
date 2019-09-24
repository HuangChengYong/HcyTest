package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
@ComponentScan("com.example.controllers")
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin(){
        ApiInfo apiInfo = new ApiInfo(
                "久落博客",
                "Swagger2接口文档",
                "1.0.0",
                null,
                "久落的博客",
                "作者:hcy",
                "http://www.huangchengyong.cn"
        );

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(false);
        return docket;
    }
}
