package pl.cango.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cango.model.ServiceType;
import pl.cango.model.schedule.ScheduleGroup;

@Repository
public interface ScheduleGroupRepository extends JpaRepository<ScheduleGroup,String> {
}
