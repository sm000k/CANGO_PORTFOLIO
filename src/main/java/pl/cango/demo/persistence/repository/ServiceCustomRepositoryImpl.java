package pl.cango.demo.persistence.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
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
//    public List<ServiceDto> getServiceByServiceAliasNamebyCriteriaBuilder(String serviceAliasName) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ServiceDto> cq = cb.createQuery(ServiceDto.class);
//
//        // Definicja korzenia dla ServiceAlias
//        Root<ServiceAlias> root = cq.from(ServiceAlias.class);
//
//        // Tworzymy dodatkowy Root dla encji Service
//        Root<Service> serviceRoot = cq.from(Service.class);
//
//
//        // Powiązanie kluczy obcych (serviceId w ServiceAlias z id w Service)
//        Predicate joinCondition = cb.equal(root.get("serviceId"), serviceRoot.get("id"));
//
//        // Filtry dla pola name w obu tabelach
//        String pattern = "%" + serviceAliasName + "%";
//        Predicate aliasNamePredicate = cb.like(root.get("name"), pattern);
//        Predicate serviceNamePredicate = cb.like(serviceRoot.get("name"), pattern);
//
//        // Łączymy wszystkie warunki
//        cq.where(cb.and(joinCondition, cb.or(aliasNamePredicate, serviceNamePredicate)));
//
//        // Wybór pól do konstrukcji ServiceDto
//        cq.select(cb.construct(
//                ServiceDto.class,
//                serviceRoot.get("id"),     // ID z Service
//                serviceRoot.get("name"),   // Nazwa z Service
//                root.get("name")           // Nazwa z ServiceAlias
//        ));
//
//        // Tworzymy zapytanie i wykonujemy
//        TypedQuery<ServiceDto> query = entityManager.createQuery(cq);
//        return query.getResultList();
//    }
    @Override
    public List<ServiceDto> getServiceByServiceAliasNamebyCriteriaBuilder(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceDto> cq = cb.createQuery(ServiceDto.class);
        Root<Service> serviceRoot = cq.from(Service.class);
        Join<Service, ServiceAlias> serviceAliasJoin = serviceRoot.join("serviceAlias", JoinType.INNER);


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


}

