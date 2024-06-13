package info.capybaratech.capydent.setup;


import com.github.f4b6a3.ulid.Ulid;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

@Configuration
@OpenAPIDefinition(info = @Info(title = "CapyDent", description = "Dentist ant patient manangement", version = "v1"))
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class DocConfig {

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
        SpringDocUtils.getConfig().replaceParameterObjectWithClass(Ulid.class, String.class);
        return openApi -> {
            Schema<?> ulidSchema = new Schema<>().type("string");
            openApi.getComponents().addSchemas("Ulid", ulidSchema);
        };
    }
}
