package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaamatRepository extends JpaRepository<Raamat, Long> {

    Raamat findFirstByLkOrderByLkDesc(int lk);
}
