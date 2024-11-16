package pl.cango.demo.persistence.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import pl.cango.demo.dto.ServiceDto;
import pl.cango.demo.model.Service;
import pl.cango.demo.model.ServiceAlias;

import java.util.List;


@Repository
public class ServiceCustomRepositoryImpl implements ServiceCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public List<ServiceDto> getServiceByServiceAliasNameHQL(String serviceAliasName) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ServiceDto> cq = cb.createQuery(ServiceDto.class);
//
//        // Tabele główne
//        Root<Service> service = cq.from(Service.class);
//        Join<Service, ServiceAlias> alias = service.join("id", JoinType.INNER);
//
//        // Select
//        cq.select(cb.construct(ServiceDto.class, service.get("id"), service.get("name"), alias.get("name")));
//
//        // Warunki WHERE
//        Predicate aliasNamePredicate = cb.like(alias.get("name"), "%" + serviceAliasName + "%");
//        Predicate serviceNamePredicate = cb.like(service.get("name"), "%" + serviceAliasName + "%");
//        cq.where(cb.or(aliasNamePredicate, serviceNamePredicate));
//
//        // Zapytanie
//        TypedQuery<ServiceDto> query = entityManager.createQuery(cq);
//        return query.getResultList();
//    }
    @Override
    public List<ServiceDto> getServiceByServiceAliasNameHQL(String serviceAliasName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceDto> cq = cb.createQuery(ServiceDto.class);

        Root<ServiceAlias> aliasRoot = cq.from(ServiceAlias.class);
        Join<ServiceAlias, Service> serviceJoin = aliasRoot.join("service", JoinType.INNER);

        cq.select(cb.construct(
                ServiceDto.class,
                serviceJoin.get("id"),
                serviceJoin.get("name"),
                aliasRoot.get("name")
        ));

        String pattern = "%" + serviceAliasName + "%";
        Predicate aliasNamePredicate = cb.like(aliasRoot.get("name"), pattern);
        Predicate serviceNamePredicate = cb.like(serviceJoin.get("name"), pattern);
        cq.where(cb.or(aliasNamePredicate, serviceNamePredicate));

        TypedQuery<ServiceDto> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
