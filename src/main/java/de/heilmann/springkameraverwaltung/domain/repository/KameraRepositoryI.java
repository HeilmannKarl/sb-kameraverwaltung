package de.heilmann.springkameraverwaltung.domain.repository;

import de.heilmann.springkameraverwaltung.domain.Kamera;
import org.springframework.data.repository.CrudRepository;

public interface KameraRepositoryI extends CrudRepository<Kamera, Integer> {
}
