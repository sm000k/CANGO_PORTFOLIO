package pl.cango.demo.persistence.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import pl.cango.demo.dto.ServiceDto;
import pl.cango.demo.model.Service;
import pl.cango.demo.model.ServiceAlias;

import java.util.List;
import java.util.stream.Collectors;


@org.springframework.stereotype.Service
public class ServiceCustomRepository {

    private EntityManager entityManager;

    private ServiceRepository serviceRepository;

    public ServiceCustomRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // select * from service where name like '%%'

    // select * from service_alias where name like '%%'

    public List<ServiceDto> getServiceByServiceAliasNamebyCriteriaBuilder(String name) {
        String name = "asdfa\"; drop database cango;"
        Query nativeQuery = entityManager.createNativeQuery("select id, name from service where name like :name", Service.class);
        nativeQuery.setParameter("name", '%basen%');

        nativeQuery.getResultList()


        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceDto> cq = cb.createQuery(ServiceDto.class);
        Root<Service> serviceRoot = cq.from(Service.class);
        Join<Service, ServiceAlias> serviceAliasJoin = serviceRoot.join("id", JoinType.LEFT);


        String pattern = "%" + name + "%";
        Predicate aliasNamePredicate = cb.like(serviceAliasJoin.get("name"), pattern);
        Predicate serviceNamePredicate = cb.like(serviceRoot.get("name"), pattern);
        // Łączymy wszystkie warunki
        cq.where(cb.or(aliasNamePredicate, serviceNamePredicate));

        cq.select(cb.construct(ServiceDto.class,
                serviceAliasJoin.get("id"),
                serviceAliasJoin.get("name"),
                serviceRoot.get("name")
        ));

        TypedQuery<ServiceDto> query = entityManager.createQuery(cq);
        return query.getResultList();
    }



    public List<ServiceDto> getServicesByName(String name) {
        List<ServiceDto> servicesByName = findServicesByName(name)
                .stream()
                .map(this::toServiceDto)
                .collect(Collectors.toList());
        List<ServiceDto> serviceAliasesByName = findServiceAliasesByName(name)
                .stream()
                .map(this::toServiceDto)
                .collect(Collectors.toList());
        servicesByName.addAll(serviceAliasesByName);
        return servicesByName;



    }

    private ServiceDto toServiceDto(Service service) {
        return new ServiceDto(service.getId().toString(), service.getName(), null);
    }

    private ServiceDto toServiceDto(ServiceAlias alias) {
        return new ServiceDto(alias.getService().getId().toString(), alias.getService().getName(), alias.getName());
    }

    private List<ServiceAlias> findServiceAliasesByName(String name) {

    }

    private List<Service> findServicesByName(String name) {
        return null;
    }


}

