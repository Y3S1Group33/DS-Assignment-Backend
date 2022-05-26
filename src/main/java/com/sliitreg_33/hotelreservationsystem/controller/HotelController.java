package com.sliitreg_33.hotelreservationsystem.controller;

import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import com.sliitreg_33.hotelreservationsystem.model.ReservationInfo;
import com.sliitreg_33.hotelreservationsystem.repository.ReservationInfoRepository;
import com.sliitreg_33.hotelreservationsystem.service.HotelService;
import com.sliitreg_33.hotelreservationsystem.service.ReservationInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/hms/hotel")
public class HotelController {

    private HotelService hotelService;
    private ReservationInfoRepository reservationInfoRepository;

    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping()
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Hotel> getAllHotelInfo(){
        return hotelService.getAllHotelInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelInfoById(@PathVariable("id") int hotelInfoId){
        return new ResponseEntity<Hotel>(hotelService.getHotelInfoById(hotelInfoId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotelInfo(@PathVariable("id") int id
            ,@RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(hotelService.updateHotelInfo(hotel, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotelInfo(@PathVariable("id") int id){

        hotelService.deleteHotelInfo(id);
        return new ResponseEntity<>("Hotel Information deleted successfully", HttpStatus.OK);
    }

//    public ResponseEntity<String> getAllHotelReservationInfo(@RequestBody List<ReservationInfo> reservation){
//        reservationInfoRepository.getAllReservationInfo(reservation);
//        return ResponseEntity.ok("Data saved");
//    }

}
