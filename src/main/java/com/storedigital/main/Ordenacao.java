package com.storedigital.main;

import java.util.Comparator;
import java.util.List;

import com.storedigital.modal.Payment;
import com.storedigital.service.Goodies;

public class Ordenacao {

	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		//Ordenando pagamento por data
		payments.stream()
				.sorted(Comparator.comparing(Payment::getDate))
				.forEach(System.out::println);
	}
	
}
