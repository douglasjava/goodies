package com.storedigital.service;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.storedigital.modal.Customer;
import com.storedigital.modal.Payment;
import com.storedigital.modal.Product;
import com.storedigital.modal.Subscription;

public class Goodies {

	private static Customer paulo;
	private static Customer rodrigo;
	private static Customer guilherme;
	private static Customer adriano;

	private static Product losAngeles;
	private static Product marginCall;
	private static Product segredo;
	private static Product beasts;
	private static Product homemDuplicado;
	private static Product poderosoChefao;

	private static LocalDateTime today;
	private static LocalDateTime yesterday;
	private static LocalDateTime lastMonth;
	
	private static BigDecimal monthlyFree;
	
	public Goodies() {
		init();
	}

	public static void init() {

		paulo = new Customer("Paulo Silveira");
		rodrigo = new Customer("Rodrigo Turini");
		guilherme = new Customer("Guilherme Silveira");
		adriano = new Customer("Adriano Almeida");

		losAngeles = new Product("LOS ANGELES – CIDADE PROIBIDA", Paths.get("/music/losAngeles.mp3"), new BigDecimal(100));
		marginCall = new Product("MARGIN CALL – O DIA ANTES DO FIM", Paths.get("/music/marginCall.mp3"), new BigDecimal(90));
		segredo = new Product("O SEGREDO DOS SEUS OLHOS", Paths.get("/music/segredoOlhos.mp3"), new BigDecimal(50));
		beasts = new Product("BEASTS OF NO NATION", Paths.get("/music/beasts.mp3"), new BigDecimal(150));
		homemDuplicado = new Product("O HOMEM DUPLICADO", Paths.get("/music/homemDuplicado.mp3"), new BigDecimal(200));
		poderosoChefao = new Product("O PODEROSO CHEFÃO", Paths.get("/music/poderosoChefao.mp3"), new BigDecimal(100));

		today = LocalDateTime.now();
		yesterday = today.minusDays(1L);
		lastMonth = today.minusMonths(2L);
		
		monthlyFree = new BigDecimal("99.90");
	}

	public static List<Payment> payments() {
		
		new Goodies();

		Payment payment1 = new Payment(asList(losAngeles, marginCall), today, paulo);
		Payment payment2 = new Payment(asList(segredo, beasts, homemDuplicado), yesterday, rodrigo);
		Payment payment3 = new Payment(asList(losAngeles, marginCall, poderosoChefao), today, adriano);
		Payment payment4 = new Payment(asList(losAngeles, segredo, homemDuplicado), lastMonth, guilherme);
		Payment payment5 = new Payment(asList(segredo, poderosoChefao, homemDuplicado), yesterday, paulo);
		Payment payment6 = new Payment(asList(beasts, marginCall, homemDuplicado), yesterday, paulo);

		List<Payment> payments = asList(payment1, payment2, payment3, payment4, payment5, payment6);

		return payments;

	}

	public static Payment payment() {
		
		new Goodies();
		
		Payment payment1 = new Payment(asList(losAngeles, marginCall), today, paulo);
		return payment1;
	}
	
	public static List<Subscription> subscriptions() {
		new Goodies();
		List<Subscription> subscriptions = null;
		
		Subscription s1 = new Subscription(monthlyFree, yesterday.minusMonths(5), paulo);		
		Subscription s2 = new Subscription(monthlyFree, yesterday.minusMonths(8), yesterday.minusMonths(1), rodrigo);
		Subscription s3 = new Subscription(monthlyFree, yesterday.minusMonths(5), yesterday.minusMonths(2), adriano);
		
		subscriptions = Arrays.asList(s1, s2, s3);
		
		return subscriptions;
	}

}
