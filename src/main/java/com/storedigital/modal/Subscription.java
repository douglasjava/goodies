package com.storedigital.modal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Subscription {

	private BigDecimal monthlyFree;
	private LocalDateTime begin;
	private Optional<LocalDateTime> end;
	private Customer customer;

	public Subscription(BigDecimal monthlyFree, LocalDateTime begin, Customer customer) {
		this.monthlyFree = monthlyFree;
		this.begin = begin;
		this.end = Optional.empty();
		this.customer = customer;
	}

	public Subscription(BigDecimal monthlyFree, LocalDateTime begin, LocalDateTime end, Customer customer) {
		this.monthlyFree = monthlyFree;
		this.begin = begin;
		this.end = Optional.of(end);
		this.customer = customer;
	}

	public BigDecimal getMonthlyFree() {
		return monthlyFree;
	}

	public void setMonthlyFree(BigDecimal monthlyFree) {
		this.monthlyFree = monthlyFree;
	}

	public LocalDateTime getBegin() {
		return begin;
	}

	public void setBegin(LocalDateTime begin) {
		this.begin = begin;
	}

	public Optional<LocalDateTime> getEnd() {
		return end;
	}

	public void setEnd(Optional<LocalDateTime> end) {
		this.end = end;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getTotalPaid() {
		return getMonthlyFree().multiply(new BigDecimal(ChronoUnit.MONTHS.between(getBegin(), getEnd().orElse(LocalDateTime.now()))));
	}
	
	@Override
	public String toString() {
		return "Subscription [monthlyFree = " + monthlyFree + ", begin = " + begin + ", end = " + end + ", "
				+ "customer = " + customer + "]";
	}

}
