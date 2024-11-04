package pl.cango.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cango.demo.model.Service;

public interface ServiceRepository extends JpaRepository<Service,String> {
}
