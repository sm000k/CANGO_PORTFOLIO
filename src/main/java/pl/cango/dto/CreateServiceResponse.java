package pl.cango.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class CreateServiceResponse {
    private String UUID;
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