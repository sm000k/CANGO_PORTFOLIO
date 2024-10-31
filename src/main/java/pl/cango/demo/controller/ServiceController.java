package pl.cango.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import pl.cango.demo.dto.ServiceDto;
import pl.cango.demo.model.Service;
import pl.cango.demo.persistence.repository.ServiceRepository;

import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/service/")
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @PostMapping("/service/add")
    public Service add(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @GetMapping("/service/{name}")
    public List<ServiceDto> getServiceDtoByAlias(@PathVariable String name) {

        return serviceRepository.getServiceByServiceAliasName(name);
    }

}
