package com.demo.vacuum.PaymentService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vacuum.PaymentService.dao.PaymentRepository;
import com.demo.vacuum.PaymentService.model.Payment;


@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentRepository repository;
	@Override
	public Payment makePayment(Payment payment) {
		return repository.save(payment);
	}

	@Override
	public List<Payment> showAllPayments() {
		return repository.findAll();
	}

	@Override
	public Payment getPaymentById(int id) {
		Optional<Payment> payment = repository.findById(id);
		if(payment.isPresent()) {
			return payment.get();
		}
		return null;
	}

	@Override
	public String deletePayment(int id) {
		Optional<Payment> payment = repository.findById(id);
		if(payment.isPresent()) {
			return "Payment deleted successfully";
		}
		return "Payment deleted failed";
	}

	@Override
	public Payment updateStatus(int id) {
		Optional<Payment> payment = repository.findById(id);
		Payment pay = new Payment();
		if(payment.isPresent()) {
			pay = payment.get();
			repository.deleteById(id);
			boolean status = pay.isPaymentStatus();
			pay.setPaymentStatus(!status);
			pay.setId(id);
			return repository.save(pay);
		}
		return null;
	}

}
