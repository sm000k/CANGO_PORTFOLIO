package pl.cango.demo.persistence.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.cango.dto.ServiceDto;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.ServiceCustomRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceCustomRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ServiceCustomRepository serviceCustomRepository;

    @Test
    public void testGetServiceByServiceAliasNameByCriteriaBuilder() {
//        // given
//        ServiceType service = ServiceType.builder().name("basen").build();
//        ServiceType saved = entityManager.persist(service);
//
//        // when
//        List<ServiceDto> list = serviceCustomRepository.getServiceByServiceAliasNameByCriteriaBuilder("basen");
//
//        // then
//        Assertions.assertEquals(1, list.size());
//        Assertions.assertEquals(saved.getId(), list.get(0).getServiceId());

    }

}
