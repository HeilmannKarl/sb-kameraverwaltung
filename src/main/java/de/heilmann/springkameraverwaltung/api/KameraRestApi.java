package de.heilmann.springkameraverwaltung.api;

import de.heilmann.springkameraverwaltung.domain.Kamera;
import de.heilmann.springkameraverwaltung.domain.repository.KameraRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KameraRestApi {

    @Autowired
    private KameraRepositoryI repository;

    /**
     * @return Liefert eine Liste von JSON Objekten, mit allen Kameras im Bestand
     */
    @GetMapping("/kamera")
    public List<Kamera> listeAllerKameras() {

        List<Kamera> kameras = new ArrayList<Kamera>();
        Iterable<Kamera> iterable = this.repository.findAll();
        iterable.forEach(kameras::add);

        return kameras;
    }
}
