package pl.cango.persistence.repository;

import pl.cango.dto.ServiceDto;

import java.util.List;

public interface ServiceCustomRepository {
    public List<ServiceDto> getServiceByServiceAliasNameByCriteriaBuilder(String aliasName);
}
