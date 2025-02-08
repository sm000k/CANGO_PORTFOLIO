package pl.cango.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cango.dto.CreateScheduleGroupRequest;
import pl.cango.dto.CreateScheduleGroupResponse;
import pl.cango.persistence.repository.ScheduleGroupRepository;
import pl.cango.service.ScheduleGroupService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ScheduleGroup")
public class ScheduleGroupController {
    private final ScheduleGroupRepository scheduleGroupRepository;
    private final ScheduleGroupService scheduleGroupService;

    public ScheduleGroupController(ScheduleGroupRepository scheduleGroupRepository, ScheduleGroupService scheduleGroupService) {
        this.scheduleGroupRepository = scheduleGroupRepository;
        this.scheduleGroupService = scheduleGroupService;
    }

    @GetMapping("/")
    String TestingUrl() {
        return "Correct Url";
    }

    @PostMapping("/")
    ResponseEntity<CreateScheduleGroupResponse> addSchedule(@RequestBody CreateScheduleGroupRequest request) {

        return new ResponseEntity<>(scheduleGroupService.createScheduleGroup(request), HttpStatus.CREATED);
    }
}
