package pl.cango.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.dto.CreateAliasResponse;
import pl.cango.model.Alias;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AliasService {

    private final AliasRepository aliasRepository;
    private final ServiceTypeRepository serviceTypeRepository;

    public CreateAliasResponse createAlias(CreateAliasRequest request) {
        Optional<ServiceType> serviceTypeOptional = serviceTypeRepository.findById(request.getServiceId());
//        if (serviceTypeOptional.isEmpty()) {
//            throw new IllegalArgumentException("Service with ID " + request.getServiceId() + " does not exist.");
//        }

        ServiceType serviceType = serviceTypeOptional.get();

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


}
