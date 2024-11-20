package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cango.model.ServiceType;

public interface ServiceRepository extends JpaRepository<ServiceType,String> {
}
