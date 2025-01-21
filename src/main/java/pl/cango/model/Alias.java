package pl.cango.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Alias {
    @Id
    @GeneratedValue (generator = "UUID")
    private UUID id;
    String name;
    @ManyToOne()
    @JoinColumn(name = "service_id")
    private ServiceType serviceType;
}
