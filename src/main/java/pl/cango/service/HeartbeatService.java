package pl.cango.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HeartbeatService {

    private final JdbcTemplate jdbcTemplate;

    public HeartbeatService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Scheduled(fixedRate = 1500) // Co 5 minut (300000 ms)
    public String sendHeartbeat() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Heartbeat sent to database.");
            return "heartBeat";
        } catch (Exception e) {
            System.err.println("Database heartbeat failed: " + e.getMessage());
        }
       return "null";
    }
}
