package pl.cango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cango.dto.CreateAliasRequest;

import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceRepository;
import pl.cango.service.AliasService;

@RestController
@RequestMapping("/servicealias")
public class AliasController {
    @Autowired
    AliasRepository aliasRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @PostMapping("/")
    public ResponseEntity<CreateAliasRequest> createAlias(@RequestBody CreateAliasRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getServiceId());
        AliasService aliasService = new AliasService(aliasRepository,serviceRepository);
        return new ResponseEntity<>(aliasService.createAlias(request), HttpStatus.CREATED);
    }

}
