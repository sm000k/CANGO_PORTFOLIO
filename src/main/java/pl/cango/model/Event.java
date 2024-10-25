package pl.cango.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Event {

    @Id
    private UUID id;
    private String name;

    private LocalDate start_date;
    private LocalDate end_date;
    private UUID company_id;
    private UUID service_id;

}
