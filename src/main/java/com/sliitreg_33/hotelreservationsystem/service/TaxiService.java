package com.sliitreg_33.hotelreservationsystem.service;

import com.sliitreg_33.hotelreservationsystem.model.Taxi;

import java.util.List;

public interface TaxiService {
    //add taxi reservation
    Taxi addTaxiReservation(Taxi taxi);

    //get all taxi reservations
    List<Taxi> getAllTaxiReservations();

    //get taxi by id
    Taxi getTaxiReservationsById(int id);

    //update taxi
    Taxi updateTaxiReservations(Taxi taxi, int id);

    //delete reservations
    void deleteTaxiReservations(Integer id);
}
