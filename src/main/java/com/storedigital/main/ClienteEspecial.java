package com.storedigital.main;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.storedigital.modal.Customer;
import com.storedigital.modal.Payment;
import com.storedigital.service.Goodies;

public class ClienteEspecial {

	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		Map<Customer, BigDecimal> totalValuePerCustomer = payments.stream()
								  .collect(Collectors.groupingBy(Payment::getCustomer, Collectors.reducing(BigDecimal.ZERO, Payment.getTotalAmount(), BigDecimal::add)));
		
		totalValuePerCustomer.entrySet().stream()
							 .sorted(Comparator.comparing(Map.Entry::getValue))
							 .forEach(System.out::println);
		
	}
	
}
