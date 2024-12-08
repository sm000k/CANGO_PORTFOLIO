package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.ServiceType;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceType, Long>, ServiceCustomRepository {
}