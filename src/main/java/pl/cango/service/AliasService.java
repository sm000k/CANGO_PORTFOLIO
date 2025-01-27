package pl.cango.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.dto.CreateAliasResponse;
import pl.cango.model.Alias;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AliasService {

    private final AliasRepository aliasRepository;
    private final ServiceTypeRepository serviceTypeRepository;

    public CreateAliasResponse createAlias(CreateAliasRequest request) {
        ServiceType serviceType = serviceTypeRepository.findById(request.getServiceId())
                .orElseThrow(() -> new ServiceTypeNotFound("Service with ID " + request.getServiceId() + " does not exist."));

        Alias serviceAlias = Alias.builder()
                .name(request.getName())
                .serviceType(serviceType)
                .build();

        aliasRepository.save(serviceAlias);

        return CreateAliasResponse.builder()
                .name(request.getName())
                .serviceId(request.getServiceId())
                .build();
    }


    public List<Alias> findAll() {
        return aliasRepository.findAll();
    }
}
