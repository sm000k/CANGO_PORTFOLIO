package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.Alias;
import pl.cango.model.ServiceType;

import java.util.Collection;

@Repository
public interface ServiceAliasRepository extends JpaRepository<ServiceAlias, String> {

    Collection<Object> findByName(String name);
}
