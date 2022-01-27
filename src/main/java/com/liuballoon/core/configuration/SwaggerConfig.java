/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/31 20:25
 */
package com.liuballoon.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 配置Swagger
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createOpenApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(this.buildApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.liuballoon.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("小程序服务")
                .description("电商小程序服务API在线文档")
                .version("0.1")
                .license("MIT LICENSE")
                .contact(new Contact("liuballoon", "https://github.com/liuballoon", "liuballoon@163.com"))
                .build();
    }
}
