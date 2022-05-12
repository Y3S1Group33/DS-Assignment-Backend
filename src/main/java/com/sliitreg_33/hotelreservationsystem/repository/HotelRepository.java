package com.sliitreg_33.hotelreservationsystem.repository;

import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
