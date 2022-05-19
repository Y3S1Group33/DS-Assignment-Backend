package com.sliitreg_33.hotelreservationsystem.service.impl;

import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.Taxi;
import com.sliitreg_33.hotelreservationsystem.repository.TaxiRepository;
import com.sliitreg_33.hotelreservationsystem.service.TaxiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiReservationsImpl implements TaxiService {

    private TaxiRepository _taxiRepository;
    public TaxiReservationsImpl(TaxiRepository taxiRepository) {
        _taxiRepository = taxiRepository;
    }

    @Override
    public Taxi addTaxiReservation(Taxi taxi) {
        return _taxiRepository.save(taxi);
    }

    @Override
    public List<Taxi> getAllTaxiReservations()  {
        return _taxiRepository.findAll();
    }

    @Override
    public Taxi getTaxiReservationsById(int id) {
        return _taxiRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Record not found"));
    }

    @Override
    public Taxi updateTaxiReservations(Taxi taxi, int id) {
        Taxi updateTaxiReservation = _taxiRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found"));

        updateTaxiReservation.setTaxiId(taxi.getTaxiId());
        updateTaxiReservation.setVehicleType(taxi.getVehicleType());
        updateTaxiReservation.setReservationId(taxi.getReservationId());
        updateTaxiReservation.setDriverName(taxi.getDriverName());
        updateTaxiReservation.setContactNumber(taxi.getContactNumber());

        _taxiRepository.save(updateTaxiReservation);

        return updateTaxiReservation;
    }

    @Override
    public void deleteTaxiReservations(Integer id) {
        _taxiRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Record not found"));
        _taxiRepository.deleteById(id);
    }
}
