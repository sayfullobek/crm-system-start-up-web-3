package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public  interface PaymentRepository  extends JpaRepository<Payment,UUID> {
}
