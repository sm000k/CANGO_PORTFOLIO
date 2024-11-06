package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.Alias;

@Repository
public interface AliasRepository extends JpaRepository<Alias, String> {
}
