package ee.tlu.eksam;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KatseRepository extends JpaRepository<Katse, Long> {

    void deleteBySportlaneId(Long sportlaneId);

    Katse findFirstBySpordialaOrderByTulemusDesc(String spordiala);

    Katse findByKatseid(Long katseid);



}
