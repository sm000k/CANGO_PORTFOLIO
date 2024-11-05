package pl.cango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cango.dto.CreateAliasRequest;

import pl.cango.model.ServiceAlias;
import pl.cango.persistence.repository.ServiceAliasRepository;

@RestController
public class ServiceAliasController {
    @Autowired
    ServiceAliasRepository serviceAliasRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping("/ServiceAlias/")
    public ResponseEntity<String> createAlias(@RequestBody CreateAliasRequest request) {
        if (!serviceRepository.existsById(request.getServiceId())) {
            return ResponseEntity.badRequest().body("Service o podanym ID nie istnieje.");
        }
        ServiceAlias serviceAlias = new ServiceAlias();
        serviceAlias.setServiceId(request.getServiceId());
        serviceAlias.setName(request.getName());
        serviceAliasRepository.save(serviceAlias);
        return ResponseEntity.ok("ServiceAlias created.");
    }

}
