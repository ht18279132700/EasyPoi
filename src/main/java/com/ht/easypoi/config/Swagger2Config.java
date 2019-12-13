package com.ht.easypoi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ht
 * @create 2019-12-13 13:50
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createXcxRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("EasyPoi接口")
                .apiInfo(new ApiInfoBuilder()
                        .title("EasyPoi导出功能")
                        .license("Apache 2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                        .termsOfServiceUrl("")
                        .version(VERSION)
                        .build())
                .select()
                .paths(PathSelectors.regex(".*/export/.*"))
                .build();
    }

}
