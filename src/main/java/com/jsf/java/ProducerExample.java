package com.jsf.java;

import java.util.Random;

import javax.enterprise.inject.Produces;

import anotations.NumberProducerAnotation;
import anotations.RandomProducer;

public class ProducerExample {
	@Produces @NumberProducerAnotation
	private int number = 10101;
	
	@Produces @RandomProducer
	public Random random() {
		return new Random();
	}
	
}
