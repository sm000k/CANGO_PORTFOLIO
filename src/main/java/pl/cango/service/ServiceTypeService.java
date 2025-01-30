package pl.cango.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.cango.dto.CreateServiceRequest;
import pl.cango.dto.CreateServiceResponse;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceTypeService {


    private final ServiceTypeRepository serviceTypeRepository;
    private final AliasRepository AliasRepository;

    private static final Logger logger = LoggerFactory.getLogger(ServiceTypeService.class);

    public CreateServiceResponse createService(CreateServiceRequest request) {
        if (serviceTypeRepository.findByName(request.getName()).isEmpty() &&
                AliasRepository.findByName(request.getName()).isEmpty()) {
            ServiceType service = ServiceType.builder()
                    .name(request.getName())
                    .build();

            serviceTypeRepository.save(service);

            return CreateServiceResponse.builder()
                    .name(service.getName())
                    .id(service.getId().toString())
                    .build();
        } else {
            logger.error("Service with name {} already exists", request.getName());
            return null;
        }

    }

    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
