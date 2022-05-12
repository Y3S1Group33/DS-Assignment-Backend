package com.sliitreg_33.hotelreservationsystem.service;

import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;

import java.util.List;

public interface ReservationInfoService {

    //reservation info
    ReservationInfo addReservationInfo(ReservationInfo reservationInfo);

    //get all reservation info
    List<ReservationInfo> getAllReservationInfo();

    //get reservation info by id
    ReservationInfo getReservationInfoById(int id);

    //update reservation info
    ReservationInfo updateReservationInfo(ReservationInfo reservationInfo, Integer id);

    //delete reservation info
    void deleteReservationInfo(int id);

}

