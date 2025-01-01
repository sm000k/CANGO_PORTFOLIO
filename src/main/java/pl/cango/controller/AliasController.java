package pl.cango.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.cango.dto.CreateAliasRequest;
import pl.cango.dto.CreateAliasResponse;
import pl.cango.service.AliasService;

@RestController
@RequestMapping("/service")
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

}
