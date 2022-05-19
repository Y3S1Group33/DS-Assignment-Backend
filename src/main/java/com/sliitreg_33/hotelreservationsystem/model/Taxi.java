package com.sliitreg_33.hotelreservationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taxi_reservations")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taxi_resrvation_id")
    private int id;

    @Column(name = "taxi_id")
    private String taxiId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "vehivle_type")
    private String vehicleType;

    @Column(name = "reservation_id")
    private String reservationId;

    @Column(name = "contact_number")
    private String contactNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
