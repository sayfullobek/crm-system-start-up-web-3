package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
}
