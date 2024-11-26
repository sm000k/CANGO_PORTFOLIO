package pl.cango.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Alias {
    @Id
    String id;
    String name;
    @ManyToOne
    @JoinColumn(name = "service_id")
    ServiceType service;
}
