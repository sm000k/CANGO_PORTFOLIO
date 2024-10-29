package pl.cango.demo.dto;

import jakarta.persistence.Id;
import lombok.Builder;

import java.util.UUID;

@Builder
public class ServiceDto {
    @Id
    UUID serviceId;
    String name;
    String alias;
}
