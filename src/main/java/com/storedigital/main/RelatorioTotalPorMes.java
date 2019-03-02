package com.storedigital.main;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.storedigital.modal.Payment;
import com.storedigital.service.Goodies;

public class RelatorioTotalPorMes {

	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		Map<YearMonth, BigDecimal> paymentsValuePerMonth = payments.stream()
				.collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate()),
					Collectors.reducing(BigDecimal.ZERO, Payment.getTotalAmount(), BigDecimal::add)));
		
		paymentsValuePerMonth.entrySet().stream()
							 .sorted(Comparator.comparing(Map.Entry::getKey))
							 .forEach(System.out::println);
		
		
	}
	
}
