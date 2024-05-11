package com.megvii.lbg.synchronizer.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

public class TimestampToLocalDateTime extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        if (Objects.isNull(jsonParser)) {
            return null;
        }
        String timeStamp = jsonParser.getText();
        return Instant.ofEpochMilli(Long.parseLong(timeStamp)).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }
}
