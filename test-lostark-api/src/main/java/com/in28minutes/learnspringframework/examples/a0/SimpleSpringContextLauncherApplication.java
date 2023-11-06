package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
	
	public static void main(String[] args) {
		// use spring
		try(var context = 
				new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}

// 1. configuration
// 2. component to interfaces or the classes (objects) that u want spring framework to create for us
// 3. and then component scan the packages
// 4. what would happen if we have multiple component
// - then we can use primary or qua lifier to avoid any multiple beans being selected