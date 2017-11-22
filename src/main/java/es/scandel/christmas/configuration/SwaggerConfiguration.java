package es.scandel.christmas.configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by fdelosrios on 9/05/16.
 */
@Configuration
public class SwaggerConfiguration {

    private static final String GROUP_NAME = "christmas-API";
    private static final String PATH_REGEX = "/gifts.*";
    private static final String API_TITLE = "Christmas API";
    private static final String API_DESCRIPTION = "REST API for the Christmas Microservice";

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME)
                .apiInfo(apiInfo()).select().paths(paths()).build();
    }

    private Predicate<String> paths() {
        return Predicates.or(PathSelectors.regex(PATH_REGEX));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(API_TITLE).description(API_DESCRIPTION).build();
    }
}