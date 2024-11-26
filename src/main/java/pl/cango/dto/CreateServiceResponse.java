package pl.cango.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.cango.model.ServiceType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateServiceResponse {
    private String UUID;
    private String name;
    private ServiceType serviceType;
}