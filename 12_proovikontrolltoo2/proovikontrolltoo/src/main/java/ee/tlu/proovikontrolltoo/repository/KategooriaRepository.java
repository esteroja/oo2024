package ee.tlu.proovikontrolltoo.repository;

import ee.tlu.proovikontrolltoo.entity.Kategooria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategooriaRepository extends JpaRepository<Kategooria, Long> {
}
