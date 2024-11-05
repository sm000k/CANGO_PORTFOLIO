package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.ServiceAlias;

@Repository
public interface ServiceAliasRepository extends JpaRepository<ServiceAlias, String> {
}
