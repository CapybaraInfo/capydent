package info.capybaratech.capydent.setup;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.ultils.UlidJsonDeserializer;
import info.capybaratech.capydent.ultils.UlidJsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JacksonConfig {
    @Bean
    public com.fasterxml.jackson.databind.Module ulidModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Ulid.class, new UlidJsonSerializer());
        module.addDeserializer(Ulid.class, new UlidJsonDeserializer());
        return module;
    }
}
