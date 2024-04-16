package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduaineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// alamklass, sp vaja extends, <> vahel, et millisele tabelile funktsioone looma hakkad + primaarvõtme tüüp
// igale tabelile on vaja luua oma repository
public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
    // Saan siia kirjutada custom repository käske, mis tagastavad kas
    //ToiduaineEntity või List<ToiduaineEntity>

    // SELECT * FROM Toiduained WHERE valk >=5;
    // JPA buddy

    List<ToiduaineEntity> findAllByValkGreaterThan(int valk);

    List<ToiduaineEntity> findAllBySysivesikBetween(int min, int max);

}
