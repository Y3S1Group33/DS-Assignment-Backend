package com.sliitreg_33.hotelreservationsystem.repository;

import com.sliitreg_33.hotelreservationsystem.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Reservations, Integer> {
}
