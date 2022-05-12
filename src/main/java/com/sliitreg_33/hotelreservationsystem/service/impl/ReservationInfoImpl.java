package com.sliitreg_33.hotelreservationsystem.service.impl;

import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;
import com.sliitreg_33.hotelreservationsystem.repository.ReservationInfoRepository;
import com.sliitreg_33.hotelreservationsystem.service.ReservationInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationInfoImpl implements ReservationInfoService {

    ReservationInfoRepository reservationInfoRepository;

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
    public void deleteReservationInfo(int id) {
        reservationInfoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not Found"));

        reservationInfoRepository.deleteById(id);

    }
}
