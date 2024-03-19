package ee.tlu.salat;

import org.springframework.data.jpa.repository.JpaRepository;

// alamklass, sp vaja extends, <> vahel, et millisele tabelile funktsioone looma hakkad + primaarvõtme tüüp
// igale tabelile on vaja luua oma repository
public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
}
