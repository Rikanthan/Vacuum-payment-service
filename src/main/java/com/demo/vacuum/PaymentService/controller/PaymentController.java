package com.demo.vacuum.PaymentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vacuum.PaymentService.model.Payment;
import com.demo.vacuum.PaymentService.service.PaymentServiceImpl;

@RestController
public class PaymentController {
	@Autowired
	PaymentServiceImpl paymentService;
	@PostMapping
	public Payment makePayment(@RequestBody Payment payment) {
		return paymentService.makePayment(payment);
	}
	@GetMapping
	public List<Payment> showAllPayments(){
		return paymentService.showAllPayments();
	}
	@GetMapping(value = "/getById")
	public Payment findPaymentbyId(@RequestParam int id) {
		return paymentService.getPaymentById(id);
	}
	@DeleteMapping
	public String deletePayment(@RequestParam int id) {
		return paymentService.deletePayment(id);
	}
	
	@PutMapping
	public Payment updatePayment(@RequestParam int id) {
		return paymentService.updateStatus(id);
	}
	
}
