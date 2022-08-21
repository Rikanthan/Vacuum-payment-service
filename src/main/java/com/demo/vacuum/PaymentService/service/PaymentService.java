package com.demo.vacuum.PaymentService.service;

import java.util.List;

import com.demo.vacuum.PaymentService.model.Payment;

public interface PaymentService {
	Payment makePayment(Payment payment);
	
	List<Payment> showAllPayments();
	
	Payment getPaymentById(int id);
	
	String deletePayment(int id);
	
	Payment updateStatus(int id);
}
