package pl.cango.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @OneToMany(mappedBy = "service")
    private Collection<Alias> serviceAlias;

    public Collection<Alias> getServiceAlias() {
        return serviceAlias;
    }

    public void setServiceAlias(Collection<Alias> serviceAlias) {
        this.serviceAlias = serviceAlias;
    }
}

