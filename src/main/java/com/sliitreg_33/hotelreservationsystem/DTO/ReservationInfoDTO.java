package com.sliitreg_33.hotelreservationsystem.DTO;

import com.sliitreg_33.hotelreservationsystem.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationInfoDTO {
    private Hotel hotel;
}


