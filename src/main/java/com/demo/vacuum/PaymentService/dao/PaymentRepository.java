package com.demo.vacuum.PaymentService.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.vacuum.PaymentService.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
	Optional<Payment> findById(int id);
}
