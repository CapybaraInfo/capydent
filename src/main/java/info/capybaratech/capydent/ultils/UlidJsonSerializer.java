package info.capybaratech.capydent.ultils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.f4b6a3.ulid.Ulid;

import java.io.IOException;

public class UlidJsonSerializer extends StdSerializer<Ulid> {
    public UlidJsonSerializer() {
        super(Ulid.class);
    }

    @Override
    public void serialize(Ulid value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());
    }


}
