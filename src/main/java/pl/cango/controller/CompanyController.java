package pl.cango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cango.model.Company;
import pl.cango.persistence.repository.CompanyRepository;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @PostMapping ("/Company/save")
    public Company createCompany (@RequestBody Company company) {
        return companyRepository.save(company);
    }
    @GetMapping ("/Company/FindAll")
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    @GetMapping("/Company/Search")
    public List<Company> searchCompaniesByName(@RequestParam("name") String name) {

        return companyRepository.findByNameContainingIgnoreCase(name);
    }
}
