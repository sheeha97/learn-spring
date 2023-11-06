package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		//1: Launch a Spring Context - 
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(HelloWorldConfiguration.class)) {
			
				//2: Configure the things that we want Spring to manage - @Configuration
				//HelloWorldConfiguration - @Configuration
				//name - @Bean
				
				//3:" Retrieving Beans managed by Spring
				System.out.println(context.getBean("name"));
				
				System.out.println(context.getBean("age"));
				
				System.out.println(context.getBean("person"));
				System.out.println(context.getBean("person2MethodCall"));
				System.out.println(context.getBean("person3Parameters"));
				
				
				// 이런식으로 이름 도는 class 를 부르는 형태로 사용 가능
				System.out.println(context.getBean("address2"));
				
				// @Primary 를 성정하는 방식으로 하나만 return
				System.out.println(context.getBean(Person.class));
				System.out.println(context.getBean(Address.class));
				
				// @Qualifier 를 성정하는 방식으로 내가 원하는 bean을 만든 person 설정 가능
				System.out.println(context.getBean("person5Qualifier"));
				
				// beans를 다 list 하는 방법
				Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			
			}
			
		}	
}