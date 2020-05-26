package com.example.springbootshiroproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Auther Carroll
 * @Date 2020/5/24
 * @e-mail ggq_carroll@163.com
 */
@Configuration
@EnableSwagger2  //开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Carrol", "https://www.baidu.com", "8888@qq.com");
        return new  ApiInfo("Carroll的Swagger的API文档",
                "你知道的越多，你不知道的越多。",
                "V1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
