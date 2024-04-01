package ee.tlu.kodutoo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoEntity, String> {
}
