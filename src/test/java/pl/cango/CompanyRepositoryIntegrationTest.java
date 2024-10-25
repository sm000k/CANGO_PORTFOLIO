package pl.cango;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.cango.model.Company;
import pl.cango.persistence.repository.CompanyRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CompanyRepositoryIntegrationTest {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void givenNewCompany_whenSave_thenCorrect() {
        Company newCompany = Company.builder()
                .name("Coca-Cola")
                .city("Washington")
                .street("Gregorian st.")
                .number("20")
                .build();
        Company insertedCompany = companyRepository.save(newCompany);
        assertThat(entityManager.find(Company.class, insertedCompany.getId())).isEqualTo(newCompany);
    }

}
