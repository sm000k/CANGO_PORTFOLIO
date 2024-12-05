package pl.cango.demo.persistence.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import pl.cango.model.ServiceType;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceCustomRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

//    @Autowired
//    ServiceCustomRepository serviceCustomRepository;
//
//    @Test
//    public void testGetServiceByServiceAliasNamebyCriteriaBuilder() {
//        // given
//        ServiceType service = ServiceType.builder().name("basen").build();
//        ServiceType saved = entityManager.persist(service);
//
//        // when
//        List<ServiceDto> list = serviceCustomRepository.getServiceByServiceAliasNamebyCriteriaBuilder("basen");
//
//        // then
//        Assertions.assertEquals(1, list.size());
//        Assertions.assertEquals(saved.getId(), list.get(0).getServiceId());
//
//    }

}
