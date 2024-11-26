package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.Alias;

import java.util.Collection;

@Repository
public interface ServiceAliasRepository extends JpaRepository<Alias, String> {

    Collection<Object> findByName(String name);
}
