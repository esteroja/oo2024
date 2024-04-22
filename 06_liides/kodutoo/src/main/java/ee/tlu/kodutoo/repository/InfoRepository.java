package ee.tlu.kodutoo.repository;

import ee.tlu.kodutoo.entity.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoEntity, String> {
}
