package br.com.alura.dojoplaces.place.repository;

import br.com.alura.dojoplaces.place.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    boolean existsByCode(String code);

    Optional<Place> findByCode(String code);
}
