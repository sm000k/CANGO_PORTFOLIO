package pl.cango.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cango.demo.model.Company;
import pl.cango.demo.persistence.repository.CompanyRepository;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/company/add")
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }


    @GetMapping("/company/")
    public List<Company> findAll() {
        return companyRepository.findAll();
    }


    @GetMapping("/company/{name}")
    public List<Company> findByName(@PathVariable String name) {
        return companyRepository.findCompaniesByName(name);
    }



}
