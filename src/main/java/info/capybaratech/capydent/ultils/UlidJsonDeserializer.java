package info.capybaratech.capydent.ultils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.f4b6a3.ulid.Ulid;

import java.io.IOException;

public class UlidJsonDeserializer extends StdDeserializer<Ulid> {

    public UlidJsonDeserializer() {
        super(Ulid.class);
    }
    @Override
    public Ulid deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return Ulid.from(p.getValueAsString());
    }
}
