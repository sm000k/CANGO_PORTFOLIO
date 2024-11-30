package pl.cango.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Service {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;


    @OneToMany(mappedBy = "service")
    private Collection<ServiceAlias> serviceAlias;

    public Collection<ServiceAlias> getServiceAlias() {
        return serviceAlias;
    }

    public void setServiceAlias(Collection<ServiceAlias> serviceAlias) {
        this.serviceAlias = serviceAlias;
    }
}
