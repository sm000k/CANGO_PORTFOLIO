package pl.cango.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.demo.model.ServiceAlias;

@Repository
public interface ServiceAliasRepository extends JpaRepository<ServiceAlias, String> {
}
