package com.storedigital.main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.storedigital.modal.Payment;
import com.storedigital.modal.Product;
import com.storedigital.service.Goodies;

public class ProdutoMaisVendido {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		Stream<Product> products = payments.stream()
				.map(Payment::getProducts)
				.flatMap(List::stream);
		
		Map<Product, Long> topProducts = payments.stream()
				.flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		//System.out.println(topProducts);
		
		topProducts.entrySet().stream().forEach(System.out::println);
		
		topProducts.entrySet().stream()
				   .max(Comparator.comparing(Map.Entry::getValue))
				   .ifPresent(System.out::println);
				
				
		
		
		
		
	}
	
}
