package pl.cango.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.Company;

import java.util.List;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    List<Company> findCompaniesByNameContainingIgnoreCase(String name);


    List<Company> findCompaniesByName(String name);
}
