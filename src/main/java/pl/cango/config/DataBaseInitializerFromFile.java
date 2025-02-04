package pl.cango.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.cango.model.Alias;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DataBaseInitializerFromFile implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseInitializerFromFile.class);
    private final ObjectMapper objectMapper;
    private final ServiceTypeRepository serviceTypeRepository;
    private final AliasRepository aliasRepository;

    public DataBaseInitializerFromFile(ObjectMapper objectMapper, ServiceTypeRepository serviceTypeRepository, AliasRepository aliasRepository, AliasRepository aliasRepository1) {

        this.objectMapper = objectMapper;
        this.serviceTypeRepository = serviceTypeRepository;
        this.aliasRepository = aliasRepository1;
    }

    @Override
    public void run(String... args) throws Exception {
        if (serviceTypeRepository.count() == 0) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/serviceTypes.json")) {
                if (inputStream == null) {
                    throw new IllegalArgumentException("File not found: data/serviceTypes.json");
                }
                // Deserialization JSON to wrapping class
                ServiceTypesWrapper wrapper = objectMapper.readValue(inputStream, ServiceTypesWrapper.class);
                List<ServiceType> serviceTypes = wrapper.getServiceTypes();

                // adding UUID to evey object
                List<ServiceType> updatedServiceTypes = serviceTypes.stream()
                        .map(service -> new ServiceType(UUID.randomUUID(), service.getName()))
                        .collect(Collectors.toList());

                serviceTypeRepository.saveAll(updatedServiceTypes);
                logger.info("Successfully loaded {} service types.", updatedServiceTypes.size());

            } catch (Exception e) {
                logger.error("Failed to load service types", e);
            }
            if (aliasRepository.count() == 0) {
                // populating alias table
                List<Alias> aliasCollection = List.of
                        (
                                new Alias(UUID.randomUUID(), "pływanie", (ServiceType) serviceTypeRepository.findByName("basen").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "pływalnia", (ServiceType) serviceTypeRepository.findByName("basen").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "football", (ServiceType) serviceTypeRepository.findByName("piłka nożna").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "futbol", (ServiceType) serviceTypeRepository.findByName("piłka nożna").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "piłka", (ServiceType) serviceTypeRepository.findByName("piłka nożna").stream().findFirst().orElse(null))
                        );
                aliasRepository.saveAll(aliasCollection);

            }
        }
    }
}

