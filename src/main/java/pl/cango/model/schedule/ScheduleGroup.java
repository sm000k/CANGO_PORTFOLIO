package pl.cango.model.schedule;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data

public class ScheduleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    LocalDateTime startDate;
    LocalDateTime endDate;

}
