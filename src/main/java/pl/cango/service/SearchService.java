package pl.cango.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cango.model.Alias;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SearchService {
    private final AliasRepository aliasRepository;
    private final ServiceTypeRepository serviceTypeRepository;

    public List<Object> SearchDistinctWithServicesAndAliases(String keyword) {
        List<ServiceType> services = serviceTypeRepository.findByNameContaining(keyword);
        List<Alias> aliases = aliasRepository.findByNameContaining(keyword);

        List<Object> results = new ArrayList<>();
        results.addAll(services);
        results.addAll(aliases.stream().map(Alias::getServiceType).distinct().toList());

        return results.stream().distinct().toList();
    }
}
