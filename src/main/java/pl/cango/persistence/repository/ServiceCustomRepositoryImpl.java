package pl.cango.persistence.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import pl.cango.dto.ServiceDto;
import pl.cango.model.ServiceType;


import java.util.List;
import java.util.stream.Collectors;

public class ServiceCustomRepositoryImpl implements ServiceCustomRepository {

    private final EntityManager entityManager;

    public ServiceCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ServiceDto> getServiceByServiceAliasNameByCriteriaBuilder(String aliasName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ServiceType> query = cb.createQuery(ServiceType.class);
        Root<ServiceType> root = query.from(ServiceType.class);

        Predicate aliasNamePredicate = cb.equal(root.get("name"), aliasName);
        query.where(aliasNamePredicate);

        List<ServiceType> serviceTypes = entityManager.createQuery(query).getResultList();

        return serviceTypes.stream()
                .map(serviceType -> new ServiceDto(serviceType.getId(), serviceType.getName()))
                .collect(Collectors.toList());
    }
}
