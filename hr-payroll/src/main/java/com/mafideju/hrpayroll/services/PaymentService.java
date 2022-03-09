package com.mafideju.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.mafideju.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Nelio", 299.0, days);
	};
}
