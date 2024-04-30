package ee.tlu.proovikontrolltoo.repository;

import ee.tlu.proovikontrolltoo.entity.Tellimus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TellimusRepository extends JpaRepository<Tellimus, Long> {
}
