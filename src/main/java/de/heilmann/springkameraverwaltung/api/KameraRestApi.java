package de.heilmann.springkameraverwaltung.api;

import de.heilmann.springkameraverwaltung.domain.Kamera;
import de.heilmann.springkameraverwaltung.domain.repository.KameraRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KameraRestApi {

    @Autowired
    private KameraRepositoryI repository;

    /**
     * @return Liefert eine Liste von JSON Objekten, mit allen Kameras im Bestand
     */
    @GetMapping("/kameras")
    public List<Kamera> listeAllerKameras() {

        List<Kamera> kameras = new ArrayList<Kamera>();
        Iterable<Kamera> iterable = this.repository.findAll();
        iterable.forEach(kameras::add);

        return kameras;
    }

    /**
     *
     * @param id
     * @return Eine Kamera mit der id vom Wert des Parameters id
     * @throws Exception
     */
    @GetMapping("/kameras/{id}")
    public Kamera getKamera(@PathVariable int id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new Exception("Kamera not found"));
    }

    /**
     * Persistiert eine neue Kamera in der DB
     * @param neueKamera
     * @return persistierte Instanz der neuen Kamera
     */
    @PostMapping("/kameras")
    public Kamera neueKamera(@RequestBody Kamera neueKamera) {
        return this.repository.save(neueKamera);
    }
}
