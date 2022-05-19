package com.sliitreg_33.hotelreservationsystem.controller;

import com.sliitreg_33.hotelreservationsystem.model.Taxi;
import com.sliitreg_33.hotelreservationsystem.service.TaxiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/taxi")
public class TaxiController {

    private TaxiService _taxiService;

    public TaxiController(TaxiService taxiService){
        _taxiService=taxiService;
    }

    @GetMapping
    public List<Taxi> getAll(){
        return _taxiService.getAllTaxiReservations();
    }

    @GetMapping("/getById")
    public ResponseEntity<Taxi> getById(@RequestParam(name="id") int id){
        return new ResponseEntity<Taxi>(_taxiService.getTaxiReservationsById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Taxi> createReservationsRecord(@RequestBody Taxi taxi){
        return new ResponseEntity<Taxi>(_taxiService.addTaxiReservation(taxi), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Taxi> updateReservationsRecord(@RequestParam(name="id") int id,@RequestBody Taxi taxi){
        return new ResponseEntity<Taxi>(_taxiService.updateTaxiReservations(taxi,id), HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteReservationsRecord(@RequestParam(name="id") int id){
        _taxiService.deleteTaxiReservations(id);
        return new ResponseEntity<>("Record deleted with id: "+id, HttpStatus.OK);
    }
}
