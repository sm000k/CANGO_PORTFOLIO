package pl.cango.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.dto.CreateAliasResponse;
import pl.cango.model.Alias;
import pl.cango.model.ServiceType;
import pl.cango.service.AliasService;

import javax.management.ServiceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/alias")
class AliasController {
    private final Logger logger = LoggerFactory.getLogger(AliasController.class);
    private final AliasService aliasService;

    AliasController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @PostMapping("/{serviceid}/alias")
    CreateAliasResponse createAlias(@RequestBody CreateAliasRequest request, @PathVariable String serviceid) {
        logger.info("Processing request to create alias: name: {}, service: {}", request.getName(), serviceid);
        return aliasService.createAlias(request);
    }

    @GetMapping("/")
    public ResponseEntity<List<Alias>> findAll() {
        List<Alias> results = aliasService.findAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(results.size()));

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(results);
    }

    @GetMapping("/test")
    public Map<String, Object> testError() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return response;
    }

}
