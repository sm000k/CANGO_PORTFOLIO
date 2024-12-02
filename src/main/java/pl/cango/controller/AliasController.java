package pl.cango.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cango.dto.CreateAliasRequest;

import pl.cango.dto.CreateAliasResponse;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceRepository;
import pl.cango.service.AliasService;

@RestController
@RequestMapping("/alias")
public class AliasController {
    @Autowired
    AliasRepository aliasRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    AliasService aliasService;
    private final Logger logger = LoggerFactory.getLogger(AliasController.class);

    @PostMapping("/")
    public CreateAliasResponse createAlias(@RequestBody CreateAliasRequest request) {
        logger.info("Processing request to create alias: name: {}, service: {}", request.getName(), request.getServiceId());
        return aliasService.createAlias(request);
    }

}
