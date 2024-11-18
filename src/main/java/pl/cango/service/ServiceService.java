package pl.cango.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import pl.cango.dto.CreateServiceRequest;
import pl.cango.dto.CreateServiceResponse;

import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.ServiceRepository;


@Service
@AllArgsConstructor
public class ServiceService {

    private final  ServiceRepository serviceRepository;

    public CreateServiceResponse createService(CreateServiceRequest request) {


        ServiceType service = ServiceType.builder()
                .name(request.getName())
                .build();
        serviceRepository.save(service);
        return CreateServiceResponse.builder()
                .name(service.getName())
                .build();
    }
}
