package com.esun.pandora.foundation.swagger;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by esun on 2018/10/26.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${app.swagger.enable:true}")
    private boolean enableSwagger;

    @Value("${app.swagger.basePackage:com.esun.pandora}")
    private String basePackage;

    @Value("${app.swagger.info.title:''}")
    private String title;
    @Value("${app.swagger.info.description:''}")
    private String description;
    @Value("${app.swagger.info.termsOfServiceUrl:''}")
    private String termsOfServiceUrl;
    @Value("${app.swagger.info.contact:''}")
    private String contact;
    @Value("${app.swagger.info.version:''}")
    private String version;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.globalOperationParameters(setToken())
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(contact)
                .version(version)
                .build();
    }


//    private List<Parameter> setToken(){
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        tokenPar.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        return pars;
//    }

    /**
     * 设置token参数
     * @return
     */
    private ApiKey apiKey() {
        return new ApiKey("apikey", "Authorization", "header");
    }
}

