package com.storedigital.main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.storedigital.modal.Customer;
import com.storedigital.modal.Payment;
import com.storedigital.modal.Product;
import com.storedigital.service.Goodies;

public class ProdutosPorCliente {

	public static void main(String[] args) {
		
		List<Payment> payments = Goodies.payments();
		
		Map<Customer, List<List<Product>>> customerToProductsList = 
				payments.stream()
				.collect(Collectors.groupingBy(Payment::getCustomer, 
				      	 Collectors.mapping(Payment::getProducts, Collectors.toList())));
		
		customerToProductsList.entrySet().stream()
							  .sorted(Comparator.comparing(e -> e.getKey().getName()))
							  .forEach(System.out::println);
							  
		
		Map<Customer, List<Product>> customerToProductsSteps =
				customerToProductsList.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, 
						e -> e.getValue().stream()
						.flatMap(List::stream)
						.collect(Collectors.toList())));
		
		customerToProductsSteps.entrySet().stream()
							   .sorted(Comparator.comparing(e -> e.getKey().getName()))
							   .forEach(System.out::println);
		
		customerToProductsSteps.entrySet().stream()
		   .sorted(Comparator.comparing(e -> e.getKey().getName()))
		   .forEach(f -> {
			   f.getValue().forEach(p -> {
				   System.out.println(p.getName() + f.getKey());
			   });
		   });
		
	}
	
}
