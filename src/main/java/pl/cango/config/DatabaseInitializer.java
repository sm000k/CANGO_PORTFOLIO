package pl.cango.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.cango.model.Alias;
import pl.cango.model.ServiceType;
import pl.cango.persistence.repository.AliasRepository;
import pl.cango.persistence.repository.ServiceTypeRepository;

import java.util.List;
import java.util.UUID;


public class DatabaseInitializer {

    private final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Bean
    public CommandLineRunner initDatabase(ServiceTypeRepository serviceTypeRepository, AliasRepository aliasRepository) {
        return args -> {
            logger.info("Loading data...");
            if (serviceTypeRepository.count() == 0) {
                // dodawanie aktywności populowanie tablicy serviType
                List <ServiceType> serviceTypeCollection = List.of(
                        new ServiceType(UUID.randomUUID(), "basen"),
                        new ServiceType(UUID.randomUUID(), "hokej"),
                        new ServiceType(UUID.randomUUID(), "tenis"),
                        new ServiceType(UUID.randomUUID(), "siatkówka"),
                        new ServiceType(UUID.randomUUID(), "szachy"),
                        new ServiceType(UUID.randomUUID(), "piłka nożna"));
                serviceTypeRepository.saveAll(serviceTypeCollection);
            }
            if (aliasRepository.count() == 0) {
                // populating alias table
                List <Alias> aliasCollection = List.of
                        (
                                new Alias(UUID.randomUUID(), "pływanie", (ServiceType) serviceTypeRepository.findByName("basen").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "pływalnia", (ServiceType) serviceTypeRepository.findByName("basen").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "football", (ServiceType) serviceTypeRepository.findByName("piłka nożna").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "futbol", (ServiceType) serviceTypeRepository.findByName("piłka nożna").stream().findFirst().orElse(null)),
                                new Alias(UUID.randomUUID(), "piłka", (ServiceType) serviceTypeRepository.findByName("piłka nożna").stream().findFirst().orElse(null))
                        );
                aliasRepository.saveAll(aliasCollection);
            }
        };

    }
}
