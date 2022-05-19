package com.sliitreg_33.hotelreservationsystem.service.impl;

import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.Reservations;
import com.sliitreg_33.hotelreservationsystem.repository.ReservationsRepository;
import com.sliitreg_33.hotelreservationsystem.service.ReservationsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsImpl implements ReservationsService {

    private ReservationsRepository _reservationsRepository;
    public ReservationsImpl(ReservationsRepository reservationsRepository) {
        _reservationsRepository = reservationsRepository;
    }

    @Override
    public Reservations addReservations(Reservations reservations) {
        return _reservationsRepository.save(reservations);
    }

    @Override
    public List<Reservations> getAllReservations() {
        return _reservationsRepository.findAll();
    }

    @Override
    public Reservations getReservationsById(int id) {
        return _reservationsRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Record not found"));
    }

    @Override
    public Reservations updateReservations(Reservations reservations, int id) {
        Reservations updateReservation = _reservationsRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found"));

        updateReservation.setUserId(reservations.getUserId());
        updateReservation.setRoomType(reservations.getRoomType());
        updateReservation.setDescription(reservations.getDescription());
        updateReservation.setnumberOfRooms(reservations.getnumberOfRooms());
        updateReservation.setPrice(reservations.getPrice());
        updateReservation.setDate(reservations.getDate());

        _reservationsRepository.save(updateReservation);

        return updateReservation;
    }

    @Override
    public void deleteReservations(Integer id) {
    _reservationsRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("Record not found"));
    _reservationsRepository.deleteById(id);
    }
}
