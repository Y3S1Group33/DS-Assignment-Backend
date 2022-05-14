package com.sliitreg_33.hotelreservationsystem.service;

import com.sliitreg_33.hotelreservationsystem.model.Payment;

import java.security.Provider;
import java.util.List;

public interface PaymentService {
       List<Payment> getAllPaymentRecords();
       Payment getPaymentRecordById(int id);
       Payment createPayment(Payment payment);
       Payment updatePaymentRecord(Payment payment,int id);
       void deletePaymentRecord(Integer id);
}
