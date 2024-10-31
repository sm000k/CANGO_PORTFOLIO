package pl.cango.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

public class ServiceDto {
    public ServiceDto(String serviceId, String name, String alias) {
        this.serviceId = serviceId;
        this.name = name;
        this.alias = alias;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    String serviceId;
    String name;
    String alias;
}
