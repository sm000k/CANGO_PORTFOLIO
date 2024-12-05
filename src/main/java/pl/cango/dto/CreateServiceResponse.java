package pl.cango.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import pl.cango.model.ServiceType;
import pl.cango.model.Alias;

import java.util.Collection;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class CreateServiceResponse {
    @Id
    private String id;
    private String name;

    @Setter
    @Getter
    @OneToMany(mappedBy = "service")
    private Collection<Alias> AliasService;

}

