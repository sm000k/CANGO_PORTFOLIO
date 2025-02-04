package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.cango.model.ServiceType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,String> {

    Collection<Object> findByName(String name);

    Optional<ServiceType> findById(String serviceId);

    List<ServiceType> findByNameContaining(String keyword);
}
