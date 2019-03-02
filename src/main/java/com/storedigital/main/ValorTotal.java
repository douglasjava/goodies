package com.storedigital.main;

import java.math.BigDecimal;

import com.storedigital.modal.Payment;
import com.storedigital.modal.Product;
import com.storedigital.service.Goodies;

public class ValorTotal {

	public static void main(String[] args) {
		
		Payment payment = Goodies.payment();
		
		//Valor Total do pagamento
		payment.getProducts().stream()
			   .map(Product::getPrice)
			   .reduce(BigDecimal::add)
			   .ifPresent(System.out::println);
		
	}
	
}
