package pl.cango.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class ServiceDto {
    private String name;
    private String ServiceId;


    public ServiceDto(UUID id, String name) {
    }
}
