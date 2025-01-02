package org.com.java8.custom.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String s = jsonParser.getText();
        try {
            return LocalDateTime.parse(s, LocalDateTimeSerializer.DATE_TIME_FORMATTER);
        } catch (DateTimeParseException dtpx) {
            System.out.println(dtpx.getMessage());
            return null;
        }
    }
}
