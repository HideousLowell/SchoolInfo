package ru.eshakin.schoolinfo.util;

import ru.eshakin.schoolinfo.model.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.name();
    }

    @Override
    public Status convertToEntityAttribute(String string) {
        return Status.valueOf(string);
    }
}