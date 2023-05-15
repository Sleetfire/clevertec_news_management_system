package ru.clevertec.news_management_service.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.clevertec.news_management_service.dto.NewsDto;

import java.io.IOException;

public class NewsDtoSerializer extends StdSerializer<NewsDto> {

    protected NewsDtoSerializer(Class<NewsDto> t) {
        super(t);
    }

    public NewsDtoSerializer() {
        this(null);
    }

    @Override
    public void serialize(NewsDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getId());
    }
}
