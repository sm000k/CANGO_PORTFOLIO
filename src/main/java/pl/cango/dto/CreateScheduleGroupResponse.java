package pl.cango.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateScheduleGroupResponse {
    String id;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
