package com.sliitreg_33.hotelreservationsystem.service;

import com.sliitreg_33.hotelreservationsystem.model.Reservations;

import java.util.List;

public interface ReservationsService {

    //reservations
    Reservations addReservations(Reservations reservations);

    //get all reservations
    List<Reservations> getAllReservations();

    //get reservations by id
    Reservations getReservationsById(int id);

    //get reservations by userId
    Reservations getReservationsByUserId(String id);

    //update reservations
    Reservations updateReservations(Reservations reservations, int id);

    //delete reservations
    void deleteReservations(Integer id);

}
