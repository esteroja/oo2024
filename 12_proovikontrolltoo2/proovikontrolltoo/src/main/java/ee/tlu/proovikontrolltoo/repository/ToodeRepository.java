package ee.tlu.proovikontrolltoo.repository;

import ee.tlu.proovikontrolltoo.entity.ToodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<ToodeEntity, Long> {

    //Toode või list<toode> - oleneb kas nt kõige suurem/vaiksem e 1 toode(find instance- advcanced) v siis mingi vahemik(find collection)
    //kõik custom päringud on getmapping (see ka custom päringu jaoks)
    List<ToodeEntity> findByHindBetween(double hindStart, double hindEnd);

    ToodeEntity findFirstByHindNotNullOrderByHindDesc();

    List<ToodeEntity> findByNimiContains(String nimi); //controller tegemata

    List<ToodeEntity> findByNimiStartsWith(String nimi); //controller tegemata

    List<ToodeEntity> findByKategooria_Id(Long id);




}
