package com.storedigital.main;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.storedigital.modal.Payment;
import com.storedigital.service.Goodies;

public class RelatorioDatas {

	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		Map<YearMonth, List<Payment>> paymentsPerMonth = payments.stream()
				.collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate())));
		
		paymentsPerMonth.entrySet().stream().forEach(System.out::println);
		
	}
	
}
