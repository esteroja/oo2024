package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduKomponent;
import org.springframework.data.jpa.repository.JpaRepository;

// extends CrudRepository<>
// extends SortingAndPagingRepository<>
// jpa kõige võimsam, annab võimaluse kustutamiseks
public interface ToiduKomponentRepository extends JpaRepository<ToiduKomponent, Long> {
}
