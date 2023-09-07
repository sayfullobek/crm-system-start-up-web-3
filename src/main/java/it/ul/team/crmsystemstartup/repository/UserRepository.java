package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
