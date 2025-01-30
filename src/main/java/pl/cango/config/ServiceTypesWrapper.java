package pl.cango.config;

import pl.cango.model.ServiceType;

import java.util.List;

public class ServiceTypesWrapper {
    private List<ServiceType> serviceTypes;

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }
}
