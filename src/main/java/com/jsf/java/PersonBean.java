package com.jsf.java;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import anotations.NumberProducerAnotation;
import anotations.PersonServiceAnotation;
import anotations.RandomProducer;

@Named
@RequestScoped
public class PersonBean {
	
	@Inject @PersonServiceAnotation(value=1)
	private PersonInterface personService;
	
	private List<Person> people;
	
	@Inject @NumberProducerAnotation
	private int numberProducer;
	
	@Inject @RandomProducer
	private Random random;
	
	private int number;
	
	@PostConstruct
	public void init() {
		people = personService.getListPerson();
		number = random.nextInt(numberProducer);
	}
	
//	@AroundConstruct
//	public void logConstruct(InvocationContext ic) {
//		System.out.println("Person bean created");
//	}
//	
//	@AroundInvoke
//	public void log(InvocationContext ic) {
//		System.out.println("Method invoke");
//	}
	
	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
