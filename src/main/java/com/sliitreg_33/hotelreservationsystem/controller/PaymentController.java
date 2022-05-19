package com.sliitreg_33.hotelreservationsystem.controller;
import com.sliitreg_33.hotelreservationsystem.model.Payment;
import com.sliitreg_33.hotelreservationsystem.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")

public class PaymentController {
    private PaymentService _paymentService;

    public PaymentController(PaymentService paymentService){
        _paymentService=paymentService;
    }
    @GetMapping
    public List<Payment> getAll(){
        return _paymentService.getAllPaymentRecords();
    }

    @GetMapping("/getById")
    public ResponseEntity<Payment> getById(@RequestParam(name="id") int id){
        return new ResponseEntity<Payment>(_paymentService.getPaymentRecordById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Payment> createPaymentRecord(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(_paymentService.createPayment(payment), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Payment> updatePaymentInfo(@RequestParam(name="id") int id,@RequestBody Payment payment){
        return new ResponseEntity<Payment>(_paymentService.updatePaymentRecord(payment,id), HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<String> deletePaymentInfo(@RequestParam(name="id") int id){
        _paymentService.deletePaymentRecord(id);
        return new ResponseEntity<>("deleted the record with id: "+id, HttpStatus.OK);
    }
}
