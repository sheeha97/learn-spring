package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record creates all the getter, setter and things u need for a class (also to_string method too)
record Person (String name, int age, Address address){ };

record Address (String firstLine, String city){ };

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "SHA";
	}
	
	@Bean
	public int age() {
		return 26;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Inha", 24, new Address("Eglington Street", "Toronto"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address()); // name, age 존재하는 bean들을 사용하여 만드는 방식
		return person;
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) { //name,age,address2
		var person = new Person(name, age, address3); // name, age 존재하는 bean들을 사용하여 만드는 방식
		return person;
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) { //name,age,address2
		var person = new Person(name, age, address); // name, age 존재하는 bean들을 사용하여 만드는 방식
		return person;
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { //name,age,address2
		var person = new Person(name, age, address); // name, age 존재하는 bean들을 사용하여 만드는 방식
		return person;
	}
	
	// 이런식으로 이름이 불리는 방식을 커스터마이즈 가능
	@Bean(name = "address2")
	@Primary
	public Address address() {
		var address = new Address("분당동 분당구 359번길 2-1", "성남시");
		return address;
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("Langsing", "Michigan");
		return address;
	}
}
