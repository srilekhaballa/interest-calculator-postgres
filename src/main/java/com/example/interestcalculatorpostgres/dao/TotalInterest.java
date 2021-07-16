package com.example.interestcalculatorpostgres.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalInterest {

	public TotalInterest(double totalInterest, double totalAmount) {
		super();
		this.totalInterest = totalInterest;
		this.totalAmount = totalAmount;
	}
	public TotalInterest() {

	}
	@Override
	public String toString() {
		return "TotalInterest [totalInterest=" + totalInterest + ", totalAmount=" + totalAmount + "]";
	}
	public double totalInterest;
	public double totalAmount;
}
