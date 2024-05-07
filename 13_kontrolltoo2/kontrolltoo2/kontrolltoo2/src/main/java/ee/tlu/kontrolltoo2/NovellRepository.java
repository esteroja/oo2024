package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NovellRepository extends JpaRepository<Novell, Long> {


    Novell findFirstByAastaOrderByAastaAsc(int aasta);

    // Novell findFirstByIdOrderByIdAsc(Long id);


    // Novell findFirstByOrderBySisuLengthAsc(String sisu);



    List<Novell> findByRaamat_nimetus(String nimetus);

    Novell findByPealkiri(String pealkiri);


}
