package com.pietro.enums.conversores;



import com.pietro.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConversor implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status categoria) {

        if (categoria == null) {
            return null;
        }
        return categoria.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Status.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
