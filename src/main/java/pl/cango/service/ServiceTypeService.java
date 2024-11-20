package pl.cango.service;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.cango.dto.CreateServiceRequest;
import pl.cango.dto.CreateServiceResponse;

import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.ServiceRepository;
import pl.cango.persistence.repository.ServiceAliasRepository;

@Service
@AllArgsConstructor
public class ServiceTypeService {


    private final ServiceRepository serviceRepository;
    private final ServiceAliasRepository ServiceAliasRepository;

    private static final Logger logger = LoggerFactory.getLogger(ServiceTypeService.class);

    public CreateServiceResponse createService(CreateServiceRequest request) {
        if (serviceRepository.findByName(request.getName()).isEmpty() &&
                ServiceAliasRepository.findByName(request.getName()).isEmpty()) {
            ServiceType service = ServiceType.builder()
                    .name(request.getName())
                    .build();
            serviceRepository.save(service);
            return CreateServiceResponse.builder()
                    .name(service.getName())
                    .build();
        } else {
            logger.error("Service with name {} already exists", request.getName());
            return null;
        }

    }
}
