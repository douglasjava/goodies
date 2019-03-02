package com.storedigital.main;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import com.storedigital.modal.Subscription;
import com.storedigital.service.Goodies;

public class Assinaturas {

	public static void main(String[] args) {
		
		//Meses por assinatura
		
		List<Subscription> subscriptions = Goodies.subscriptions();
		
		subscriptions.stream()
					 .sorted(Comparator.comparing(Subscription::getBegin))
					 .forEach(s -> System.out.println(s.getTotalPaid()));
		
		BigDecimal totalPaid = subscriptions.stream().map(Subscription::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		System.out.println("Valor Total pago: " + totalPaid);
		
	}
	
}
