package pl.cango.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.dto.CreateAliasResponse;
import pl.cango.model.Alias;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceRepository;

import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AliasService {

    private final AliasRepository aliasRepository;
    private final ServiceRepository serviceRepository;

    public CreateAliasResponse createAlias(CreateAliasRequest request) {
        if (!serviceRepository.existsById(request.getServiceId())) {
            throw new IllegalArgumentException("Service with ID " + request.getServiceId() + " does not exist.");
        }


        Alias serviceAlias = Alias.builder()
                .name(request.getName())
                .serviceId(request.getServiceId())
                .build();

        aliasRepository.save(serviceAlias);

        return CreateAliasResponse.builder()
                .name(request.getName())
                .serviceId(request.getServiceId())
                .build();
    }


}
