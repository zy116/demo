package com.boss.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/17 14:30
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("邹优").apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("", "", "");
        return new ApiInfo("zouyou的swagger",
                "Api Documentation",
                "1.0",
                "https://github.com/zy116",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
