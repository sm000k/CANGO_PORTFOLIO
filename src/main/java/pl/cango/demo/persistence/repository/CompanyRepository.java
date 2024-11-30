package pl.cango.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.demo.model.Company;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    List<Company> findCompaniesByNameContainingIgnoreCase(String name);

    List<Company> findCompaniesByName(String name);

    List<Company> findByNameContainingIgnoreCase(String name);
}
