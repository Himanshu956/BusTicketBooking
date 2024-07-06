package com.wipro.bus.service;

import java.util.List;
import java.util.Optional;

import com.wipro.bus.entities.Payment;

public interface PaymentService {
	    
	    Payment savePayment(Payment payment);
	    
	    Optional<Payment> getPaymentById(Long paymentId);
	    
	    List<Payment> getAllPayments();
	    
	    Payment updatePayment(Long paymentId, Payment paymentDetails);
	    
	    void deletePayment(Long paymentId);
	}



