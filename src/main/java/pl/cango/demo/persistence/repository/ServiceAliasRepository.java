package pl.cango.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cango.demo.dto.ServiceDto;
import pl.cango.demo.model.ServiceAlias;

import java.util.List;

@Repository
public interface ServiceAliasRepository extends JpaRepository<ServiceAlias, String> {
}
