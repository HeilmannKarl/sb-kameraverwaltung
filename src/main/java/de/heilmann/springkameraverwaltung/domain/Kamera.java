package de.heilmann.springkameraverwaltung.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Kamera {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    private String kameramodell;
    private Hersteller hersteller;
    private String sensorformat;
    private String anzahlPixel;

    public Kamera() {
    }

    public Kamera(String kameramodell, Hersteller hersteller, String sensorformat, String anzahlPixel) {

        this.kameramodell = kameramodell;
        this.hersteller = hersteller;
        this.sensorformat = sensorformat;
        this.anzahlPixel = anzahlPixel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKameramodell() {
        return kameramodell;
    }

    public void setKameramodell(String kameramodell) {
        this.kameramodell = kameramodell;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public String getSensorformat() {
        return sensorformat;
    }

    public void setSensorformat(String sensorformat) {
        this.sensorformat = sensorformat;
    }

    public String getAnzahlPixel() {
        return anzahlPixel;
    }

    public void setAnzahlPixel(String anzahlPixel) {
        this.anzahlPixel = anzahlPixel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.kameramodell, this.sensorformat, this.anzahlPixel);
    }

    @Override
    public String toString() {
        return "Kamera{" + "id=" + this.id +
                ", kameramodell='" + this.kameramodell + '\'' +
                ", hersteller='" + this.hersteller.value() + '\'' +
                ", sensorformat='" + this.sensorformat + '\'' +
                ", anzahlPixel='" + this.anzahlPixel + '\'' +
                '}';
    }
}
