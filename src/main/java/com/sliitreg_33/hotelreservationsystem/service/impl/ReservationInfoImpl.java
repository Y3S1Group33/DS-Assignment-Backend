package com.sliitreg_33.hotelreservationsystem.service.impl;

import com.sliitreg_33.hotelreservationsystem.DTO.ReservationInfoDTO;
import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;
import com.sliitreg_33.hotelreservationsystem.repository.HotelRepository;
import com.sliitreg_33.hotelreservationsystem.repository.ReservationInfoRepository;
import com.sliitreg_33.hotelreservationsystem.service.ReservationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ReservationInfoImpl implements ReservationInfoService {

    @Autowired
    ReservationInfoRepository reservationInfoRepository;
    @Autowired
    HotelRepository hotelRepository;

    public ReservationInfoImpl(ReservationInfoRepository reservationInfoRepository){
        this.reservationInfoRepository = reservationInfoRepository;
    }

    @Override
    public ReservationInfo addReservationInfo(ReservationInfo reservationInfo) {
        return reservationInfoRepository.save(reservationInfo);
    }

    @Override
    public List<ReservationInfo> getAllReservationInfo() {
        return reservationInfoRepository.findAll();
    }

    @Override
    public ReservationInfo getReservationInfoById(int id) {
        return reservationInfoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not Found"));
    }

    @Override
    public ReservationInfo updateReservationInfo(ReservationInfo reservationInfo, Integer id) {

        ReservationInfo existingReservationInfo = reservationInfoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found"));

        existingReservationInfo.setRoomType(reservationInfo.getRoomType());
        existingReservationInfo.setDescription(reservationInfo.getDescription());
        existingReservationInfo.setAvailableRooms(reservationInfo.getAvailableRooms());
        existingReservationInfo.setPrice(reservationInfo.getPrice());

        reservationInfoRepository.save(existingReservationInfo);

        return existingReservationInfo;
    }

    @Override
    public void deleteReservationInfo(int id) {

        reservationInfoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not Found"));

        reservationInfoRepository.deleteById(id);

    }

    @Override
    public Hotel addHotel(ReservationInfoDTO reservationInfoDTO) {
        return hotelRepository.save(reservationInfoDTO.getHotel());
    }

    @Override
    public List<Hotel> getAllHotelReservationInfo() {
        return hotelRepository.findAll();
    }
}
