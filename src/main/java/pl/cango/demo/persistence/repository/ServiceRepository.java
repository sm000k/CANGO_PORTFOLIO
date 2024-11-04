package pl.cango.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.demo.model.Company;
import pl.cango.demo.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

}
