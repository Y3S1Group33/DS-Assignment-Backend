package com.sliitreg_33.hotelreservationsystem.controller;

import com.sliitreg_33.hotelreservationsystem.DTO.ReservationInfoDTO;
import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;
import com.sliitreg_33.hotelreservationsystem.repository.HotelRepository;
import com.sliitreg_33.hotelreservationsystem.service.HotelService;
import com.sliitreg_33.hotelreservationsystem.service.ReservationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservationInfo")
public class ReservationInfoController {

    @Autowired
    private ReservationInfoService reservationInfoService;

    @Autowired
    private HotelService hotelService;

    public ReservationInfoController(ReservationInfoService reservationInfoService){
        this.reservationInfoService = reservationInfoService;
    }

    //add reservation information
    @PostMapping()
    public ResponseEntity<ReservationInfo> addReservationInfo(@RequestBody ReservationInfo reservationInfo){
        return new ResponseEntity<ReservationInfo>(reservationInfoService.addReservationInfo(reservationInfo), HttpStatus.CREATED);
    }

    //get all reservation information
    @GetMapping()
    public List<ReservationInfo> getAllReservationInfo(){
        return reservationInfoService.getAllReservationInfo();
    }

    //get one reservation information
    @GetMapping("/{id}")
    public ResponseEntity<ReservationInfo> getReservationInfoById(@PathVariable("id") int reservationInfoId){
        return new ResponseEntity<ReservationInfo>(reservationInfoService.getReservationInfoById(reservationInfoId), HttpStatus.OK);
    }

    //update Reservation information
    @PutMapping("/{id}")
    public ResponseEntity<ReservationInfo> updateReservationInfo(@PathVariable("id") int id
    ,@RequestBody ReservationInfo reservationInfo){
        return new ResponseEntity<ReservationInfo>(reservationInfoService.updateReservationInfo(reservationInfo, id), HttpStatus.OK);
    }

    //delete reservation information
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservationInfo(@PathVariable("id") int id){

        reservationInfoService.deleteReservationInfo(id);
        return new ResponseEntity<>("Reservation Information deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<Hotel> addHotel(@RequestBody ReservationInfoDTO reservationInfoDTO){
        return new ResponseEntity<Hotel>(reservationInfoService.addHotel(reservationInfoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public List<Hotel> getAllHotelReservationInfo(){
        return reservationInfoService.getAllHotelReservationInfo();
    }
}
