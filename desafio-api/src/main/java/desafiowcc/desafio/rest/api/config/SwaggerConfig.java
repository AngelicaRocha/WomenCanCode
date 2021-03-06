package desafiowcc.desafio.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("desafiowcc.desafio.rest.api"))
                .paths(regex("/postagens.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "POSTAGENS API REST",
                "API REST para gerenciamento de blogs",
                "1.0",
                "Termos de uso",
                new Contact("Angélica Rocha",
                        "https://github.com/AngelicaRocha/WomenCanCode",
                        "angelicarocha67@yahoo.com.br"),
                        "Versão 1.0",
                        "URL da licença",
                        new ArrayList<VendorExtension>()
        );

        return apiInfo;


    }

}
