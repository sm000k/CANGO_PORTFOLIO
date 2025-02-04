package pl.cango.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;
import pl.cango.service.SearchService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<Object>> search(@RequestParam("keyword") String keyword) {
        List<Object> result = searchService.SearchDistinctWithServicesAndAliases(keyword);
        if (result.isEmpty()){
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok(result);
    }
}
