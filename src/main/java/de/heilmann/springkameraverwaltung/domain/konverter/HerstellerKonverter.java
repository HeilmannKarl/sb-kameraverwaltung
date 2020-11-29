package de.heilmann.springkameraverwaltung.domain.konverter;

import de.heilmann.springkameraverwaltung.domain.Hersteller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Konvertiert die Werte des Enum-Property 'hersteller' von der Klasse 'Kamera', um einen vernuenftig lesbaren Wert
 * in der DB zu Speichern, anstelle des Ordinalwertes.
 */
@Converter(autoApply = true)
public class HerstellerKonverter implements AttributeConverter<Hersteller, String> {

    /**
     * Ermittelt den value von hersteller, damit dieser beim Speichern des Entity in der DB verwendet wird.
     * @param hersteller
     * @return liefert den value von hersteller
     */
    @Override
    public String convertToDatabaseColumn(Hersteller hersteller) {
        if (hersteller == null) {
            return null;
        }
        return hersteller.value();
    }

    /**
     * Wandelt einen aus der DB gelesenen Wert um in eine Konstante vom Typ Hersteller.
     * @param value
     * @return Konstante vom Typ Hersteller
     */
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
