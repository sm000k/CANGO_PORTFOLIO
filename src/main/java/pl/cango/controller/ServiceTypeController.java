package pl.cango.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cango.dto.CreateServiceRequest;
import pl.cango.dto.CreateServiceResponse;
import pl.cango.model.Company;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.ServiceTypeRepository;
import pl.cango.service.ServiceTypeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/service")
public class ServiceTypeController {


    private final ServiceTypeService serviceTypeService;

    public ServiceTypeController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @PostMapping("/")
    public ResponseEntity<CreateServiceResponse> addService(@RequestBody CreateServiceRequest request) {
        return new ResponseEntity<>(serviceTypeService.createService(request), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<ServiceType>> findAll() {
        List<ServiceType> results = serviceTypeService.findAll();

        // Przykład z nagłówkami
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(results.size()));

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(results);
    }
}
