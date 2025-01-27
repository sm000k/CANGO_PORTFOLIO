package pl.cango.service;

public class ServiceTypeNotFound extends RuntimeException {
    public ServiceTypeNotFound(String message) {
        super(message);
    }
}
