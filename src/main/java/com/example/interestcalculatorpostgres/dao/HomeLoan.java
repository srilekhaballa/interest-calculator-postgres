package com.example.interestcalculatorpostgres.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "interest_rates")
public class HomeLoan implements Serializable { 
	
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Id
	  @Column(name="interest_id") 
	  private long interestId;
	 
	private double rate;
	@NotNull(message="tenure can't be null")
	@Positive
	private double tenure;
	@NotNull(message="loanAmount can't be null")
	@Positive
	private double loanAmount;

}
