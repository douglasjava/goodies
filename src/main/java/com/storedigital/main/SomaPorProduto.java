package com.storedigital.main;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.storedigital.modal.Payment;
import com.storedigital.modal.Product;
import com.storedigital.service.Goodies;

public class SomaPorProduto {

	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		Map<Product, BigDecimal> totalValuePerProduct = payments.stream()
				.flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(Function.identity(), 
				Collectors.reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)));

		totalValuePerProduct.entrySet().stream()
							.sorted(Comparator.comparing(Map.Entry::getValue))
							.forEach(System.out::println);
		
		
	}
	
}
