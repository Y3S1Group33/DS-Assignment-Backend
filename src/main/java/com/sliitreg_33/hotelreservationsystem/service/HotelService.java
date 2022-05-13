package com.sliitreg_33.hotelreservationsystem.service;

import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;

import java.util.List;

public interface HotelService {

    //add hotel information
    Hotel addHotel(Hotel hotel);

    //get all hotel information
    List<Hotel> getAllHotelInfo();

    //get hotel information by id
    Hotel getHotelInfoById(int id);

    //update hotel information
    Hotel updateHotelInfo(Hotel hotel, Integer id);

    //delete hotel information
    void deleteHotelInfo(Integer id);

//    List<ReservationInfo> getAllHotelReservationInfo();
}
