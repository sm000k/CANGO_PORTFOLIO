package pl.cango.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.cango.dto.CreateScheduleGroupRequest;
import pl.cango.dto.CreateScheduleGroupResponse;
import pl.cango.model.schedule.ScheduleGroup;
import pl.cango.persistence.repository.ScheduleGroupRepository;

@Service
@AllArgsConstructor
@Slf4j
public class ScheduleGroupService {

    private final ScheduleGroupRepository scheduleGroupRepository;

    public CreateScheduleGroupResponse createScheduleGroup(CreateScheduleGroupRequest request) {
        // Validate the request
        if (request == null) {
            log.error("CreateScheduleGroupRequest is null");
            throw new IllegalArgumentException("Request cannot be null");
        }

        if (request.getStartDate() == null || request.getEndDate() == null) {
            log.error("Invalid schedule dates: startDate or endDate is null. Received startDate: {}, endDate: {}",
                    request.getStartDate(), request.getEndDate());
            throw new IllegalArgumentException("Both startDate and endDate must be provided");
        }

        // Ensure that the start date is before the end date
        if (request.getStartDate().isAfter(request.getEndDate())) {
            log.error("Invalid schedule dates: startDate is after endDate. startDate: {}, endDate: {}",
                    request.getStartDate(), request.getEndDate());
            throw new IllegalArgumentException("Start date must be before end date");
        }

        log.info("Creating schedule group with startDate: {} and endDate: {}",
                request.getStartDate(), request.getEndDate());

        // Build and save the schedule group
        ScheduleGroup scheduleGroup = ScheduleGroup.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        scheduleGroupRepository.save(scheduleGroup);
        log.info("Schedule group created with ID: {}", scheduleGroup.getId());

        // Build the response object
        return CreateScheduleGroupResponse.builder()
                .id(scheduleGroup.getId().toString())
                .startDate(scheduleGroup.getStartDate())
                .endDate(scheduleGroup.getEndDate())
                .build();
    }
}
