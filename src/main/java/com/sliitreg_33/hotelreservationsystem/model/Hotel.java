package com.sliitreg_33.hotelreservationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_type")
    private String hotelType;

    @Column(name = "hotel_description")
    private String hotelDescription;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_telephone")
    private String hotelTelephone;
}
