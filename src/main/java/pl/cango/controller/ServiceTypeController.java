package pl.cango.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cango.dto.CreateServiceRequest;
import pl.cango.dto.CreateServiceResponse;
import pl.cango.persistence.repository.ServiceRepository;
import pl.cango.service.ServiceTypeService;

@RestController
@RequestMapping("/service")
public class ServiceTypeController {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ServiceTypeService serviceTypeService;

    @PostMapping("/")
    public ResponseEntity<CreateServiceResponse> addService(@RequestBody CreateServiceRequest request) {
        return new ResponseEntity<>(serviceTypeService.createService(request), HttpStatus.CREATED);
    }
}
