package pl.cango.service;


import org.springframework.stereotype.Service;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.model.Alias;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceRepository;

import java.util.Random;
import java.util.UUID;

@Service
public class AliasService {

    private final AliasRepository aliasRepository;
    private final ServiceRepository serviceRepository;

    public AliasService(AliasRepository aliasRepository, ServiceRepository serviceRepository) {
        this.aliasRepository = aliasRepository;
        this.serviceRepository = serviceRepository;
    }

    public CreateAliasRequest createAlias(CreateAliasRequest request) {
        if (!serviceRepository.existsById(request.getServiceId())) {
            throw new IllegalArgumentException("Service with ID " + request.getServiceId() + " does not exist.");
        }

        Random random = new Random();
        Alias serviceAlias = Alias.builder()
                .id(String.valueOf(random.nextInt()))
                .name(request.getName())
                .serviceId(request.getServiceId())
                .build();

        aliasRepository.save(serviceAlias);

        return CreateAliasRequest.builder()
                .name(request.getName())
                .serviceId(request.getServiceId())
                .build();
    }


}
