package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cango.model.Service;

public interface ServiceRepository extends JpaRepository<Service,String> {
}
