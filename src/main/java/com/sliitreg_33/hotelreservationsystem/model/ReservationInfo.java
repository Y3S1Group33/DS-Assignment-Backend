package com.sliitreg_33.hotelreservationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation_info")
public class ReservationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationInfo_id")
    private int id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "description")
    private String description;

    @Column(name = "available_rooms")
    private int availableRooms;

    @Column(name = "price")
    private String price;

}
