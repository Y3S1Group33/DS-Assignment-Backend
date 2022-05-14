package com.sliitreg_33.hotelreservationsystem.service.impl;
import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.Payment;
import com.sliitreg_33.hotelreservationsystem.repository.PaymentRepository;
import com.sliitreg_33.hotelreservationsystem.service.PaymentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository _paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        _paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPaymentRecords() {
        return _paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentRecordById(int id) {
        return _paymentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not Found"));
    }

    @Override
    public Payment createPayment(Payment payment) {
        return _paymentRepository.save(payment);
    }

    @Override
    public Payment updatePaymentRecord(Payment payment, int id) {
        Payment updatingPayment = _paymentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found"));

        updatingPayment.setCardHolderName(payment.getCardHolderName());
        updatingPayment.setCreditCardNumber(payment.getCreditCardNumber());
        updatingPayment.setCvc(payment.getCvc());
        updatingPayment.setExpDate(payment.getExpDate());

        _paymentRepository.save(updatingPayment);

        return updatingPayment;
    }

    @Override
    public void deletePaymentRecord(Integer id) {
        _paymentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not Found in DB"));
                _paymentRepository.deleteById(id);
    }
}
