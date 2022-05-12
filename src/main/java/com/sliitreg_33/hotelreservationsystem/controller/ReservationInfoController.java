package com.sliitreg_33.hotelreservationsystem.controller;

import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;
import com.sliitreg_33.hotelreservationsystem.service.ReservationInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hms/reservationInfo")
public class ReservationInfoController {

    private ReservationInfoService reservationInfoService;

    public ReservationInfoController(ReservationInfoService reservationInfoService){
        this.reservationInfoService = reservationInfoService;
    }

    @PostMapping()
    public ResponseEntity<ReservationInfo> addReservationInfo(@RequestBody ReservationInfo reservationInfo){
        return new ResponseEntity<ReservationInfo>(reservationInfoService.addReservationInfo(reservationInfo), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<ReservationInfo> getAllReservationInfo(){
        return reservationInfoService.getAllReservationInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationInfo> getReservationInfoById(@PathVariable("id") int reservationInfoId){
        return new ResponseEntity<ReservationInfo>(reservationInfoService.getReservationInfoById(reservationInfoId), HttpStatus.OK);
    }
}
