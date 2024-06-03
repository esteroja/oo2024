package ee.tlu.eksam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KatseRepository extends JpaRepository<Katse, Long> {

    void deleteBySportlaneId(Long sportlaneId);

}
