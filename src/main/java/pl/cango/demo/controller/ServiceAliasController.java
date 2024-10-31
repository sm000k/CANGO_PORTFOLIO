package pl.cango.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cango.demo.dto.ServiceDto;
import pl.cango.demo.model.ServiceAlias;
import pl.cango.demo.persistence.repository.ServiceAliasRepository;

import java.util.List;

@RestController
public class ServiceAliasController {
    @Autowired
    private final ServiceAliasRepository serviceAliasRepository;

    public ServiceAliasController(ServiceAliasRepository serviceAliasRepository) {
        this.serviceAliasRepository = serviceAliasRepository;
    }

    @GetMapping("/servicesalias/")
    public List<ServiceAlias> getAllServiceAlias() {
        return serviceAliasRepository.findAll();
    }

    @PostMapping("servicealias/add")
    public ServiceAlias createServiceAlias(@RequestBody ServiceAlias serviceAlias) {
        return serviceAliasRepository.save(serviceAlias);
    }

}
