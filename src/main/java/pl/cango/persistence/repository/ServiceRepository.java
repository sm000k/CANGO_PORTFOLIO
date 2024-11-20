package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.ServiceType;

import java.util.Collection;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceType, String> {

    Collection<Object> findByName(String name);
}
