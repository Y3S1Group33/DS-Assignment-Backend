package com.sliitreg_33.hotelreservationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "traveler_reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOf_rooms")
    private int numberOfRooms;

    @Column(name = "price")
    private String price;

    @Column(name = "date")
    private String date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getnumberOfRooms() {
        return numberOfRooms;
    }

    public void setnumberOfRooms(int availableRooms) {
        this.numberOfRooms = availableRooms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
