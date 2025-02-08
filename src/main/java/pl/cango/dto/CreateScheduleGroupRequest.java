package pl.cango.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class CreateScheduleGroupRequest {

    // Use @JsonProperty to explicitly map the JSON key "startDate" to this field
    @JsonProperty("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // Adjust the pattern if needed
    private LocalDateTime startDate;

    @JsonProperty("endDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDate;

}
