package pl.cango.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String city;
    private String street;
    private String number;

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", city=" + city + ", street=" + street + " number=" + number + "]";
    }
}
