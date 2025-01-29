package pl.cango.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;
import pl.cango.service.SearchService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping
    public ResponseEntity<List<Object>> search(@RequestParam("keyword") String keyword) {

        return ResponseEntity.ok(searchService.SearchDistinctWithServicesAndAliases(keyword));
    }
}
