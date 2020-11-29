package de.heilmann.springkameraverwaltung.domain.konverter;

import de.heilmann.springkameraverwaltung.domain.Hersteller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class HerstellerKonverter implements AttributeConverter<Hersteller, String> {

    @Override
    public String convertToDatabaseColumn(Hersteller hersteller) {
        if (hersteller == null) {
            return null;
        }
        return hersteller.value();
    }

    @Override
    public Hersteller convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(Hersteller.values())
                .filter(c -> c.value().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
