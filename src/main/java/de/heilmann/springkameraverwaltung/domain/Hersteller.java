package de.heilmann.springkameraverwaltung.domain;

public enum Hersteller {

    CANON("Canon"),
    SONY("Sony"),
    NIKON("Nikon");

    private String value;

    private Hersteller(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
