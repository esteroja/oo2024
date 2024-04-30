package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduKomponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// extends CrudRepository<>
// extends SortingAndPagingRepository<>
// jpa kõige võimsam, annab võimaluse kustutamiseks
public interface ToiduKomponentRepository extends JpaRepository<ToiduKomponent, Long> {


    // List<ToiduKomponent> findByToit_Id(Long id); //toidu id kaudu leia kõik toidukomponendid üles -> tagastus toidu faili sees, võib ka toidukomponendi sisse teha
}
