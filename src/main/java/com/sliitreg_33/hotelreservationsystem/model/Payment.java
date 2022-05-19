package com.sliitreg_33.hotelreservationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Base64;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cardHolderName")
    private String cardHolderName;

    @Column(name = "creditCardNumber")
    private String creditCardNumber;

    @Column(name = "cvc")
    private String cvc;
    @Column(name = "expDate")
    private String expDate;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        String encodedCreditCardNumber = Base64.getEncoder().encodeToString(creditCardNumber.getBytes());
        this.creditCardNumber = encodedCreditCardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        String encodedCVC = Base64.getEncoder().encodeToString(cvc.getBytes());
        this.cvc = encodedCVC;
    }

    public String getExpDate() {

        return expDate;
    }

    public void setExpDate(String expDate) {

        this.expDate = expDate;
    }

}
