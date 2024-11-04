package pl.cango.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.cango.demo.model.Service;
import pl.cango.demo.persistence.repository.ServiceRepository;

@RestController
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @PostMapping("/service/add")
    public Service addService(@RequestBody String name) {
        Service service = new Service();
        service.setName(name);
        return serviceRepository.save(service);
    }
}
