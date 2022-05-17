package com.sliitreg_33.hotelreservationsystem.controller;

import com.sliitreg_33.hotelreservationsystem.model.Reservations;
import com.sliitreg_33.hotelreservationsystem.service.ReservationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    private ReservationsService _reservationsService;

    public ReservationsController(ReservationsService reservationsService){
        _reservationsService=reservationsService;
    }

    @GetMapping
    public List<Reservations> getAll(){
        return _reservationsService.getAllReservations();
    }

    @GetMapping("/getById")
    public ResponseEntity<Reservations> getById(@RequestParam(name="id") int id){
        return new ResponseEntity<Reservations>(_reservationsService.getReservationsById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Reservations> createReservationsRecord(@RequestBody Reservations reservations){
        return new ResponseEntity<Reservations>(_reservationsService.addReservations(reservations), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Reservations> updateReservationsRecord(@RequestParam(name="id") int id,@RequestBody Reservations reservations){
        return new ResponseEntity<Reservations>(_reservationsService.updateReservations(reservations,id), HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteReservationsRecord(@RequestParam(name="id") int id){
        _reservationsService.deleteReservations(id);
        return new ResponseEntity<>("Record deleted with id: "+id, HttpStatus.OK);
    }
}
