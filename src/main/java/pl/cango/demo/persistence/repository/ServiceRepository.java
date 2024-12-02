package pl.cango.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cango.demo.dto.ServiceDto;
import pl.cango.demo.model.Service;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<Service, UUID>, ServiceCustomRepository {
//    @Query("SELECT new pl.cango.demo.dto.ServiceDto(s.id, s.name, a.name) " +
//            "FROM ServiceAlias a JOIN Service s ON a.serviceId = s.id " +
//            "WHERE a.name LIKE CONCAT('%', :serviceAliasName, '%') " +
//            "OR s.name LIKE CONCAT('%', :serviceAliasName, '%')")
//    List<ServiceDto> getServiceByServiceAliasName(String serviceAliasName);



}
