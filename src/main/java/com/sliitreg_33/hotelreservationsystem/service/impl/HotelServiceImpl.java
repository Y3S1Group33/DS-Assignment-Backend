package com.sliitreg_33.hotelreservationsystem.service.impl;

import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;
import com.sliitreg_33.hotelreservationsystem.repository.HotelRepository;
import com.sliitreg_33.hotelreservationsystem.repository.ReservationInfoRepository;
import com.sliitreg_33.hotelreservationsystem.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private ReservationInfoRepository reservationInfoRepository;

    public HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotelInfo() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelInfoById(int id) {
        return hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not Found"));
    }

    @Override
    public Hotel updateHotelInfo(Hotel hotel, Integer id) {

        Hotel existingHotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found"));

        existingHotel.setHotelName(hotel.getHotelName());
        existingHotel.setHotelType(hotel.getHotelType());
        existingHotel.setHotelDescription(hotel.getHotelDescription());
        existingHotel.setHotelAddress(hotel.getHotelAddress());
        existingHotel.setHotelTelephone(hotel.getHotelTelephone());

        hotelRepository.save(existingHotel);
        return existingHotel;
    }

    @Override
    public void deleteHotelInfo(Integer id) {
        hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found"));

        hotelRepository.deleteById(id);

    }

//    @Override
//    public List<ReservationInfo> getAllHotelReservationInfo() {
//        return reservationInfoRepository.findAll();
//    }

}
