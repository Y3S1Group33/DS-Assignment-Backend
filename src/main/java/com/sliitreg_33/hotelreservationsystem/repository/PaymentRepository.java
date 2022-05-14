package com.sliitreg_33.hotelreservationsystem.repository;
import com.sliitreg_33.hotelreservationsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
