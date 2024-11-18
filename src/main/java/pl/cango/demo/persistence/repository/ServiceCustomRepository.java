package pl.cango.demo.persistence.repository;

import pl.cango.demo.dto.ServiceDto;

import java.util.List;

public interface ServiceCustomRepository {
    List<ServiceDto> getServiceByServiceAliasNamebyCriteriaBuilder(String name);
}
