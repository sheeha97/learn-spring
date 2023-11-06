package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// YourBusinessClass
// Dependency1
// Dependency2

@Component
class YourBusinessClass {
	
	//this is an example of field injection
	//@Autowired
	Dependency1 dependency;
	
	//@Autowired
	Dependency2 dependency2;
	
	// constructor injection
	// this will still work without @Autowired
	// constructor auto wires
	// spring will automatically create dependency according to the constructor
	// it is recommended because all the initalization happens in one method
	// and once the init is done, beans are created
	@Autowired
	public YourBusinessClass(Dependency1 dependency, Dependency2 dependency2) {
		super();
		this.dependency = dependency;
		this.dependency2 = dependency2;
		System.out.println("Constructor Injection");
	}

	// setter injection
	/*
	 * @Autowired 
	 * public void setDependency(Dependency1 dependency) {
	 * 	System.out.println("Setter Injection - setDependency1");this.dependency =
	 * dependency; }
	 * 
	 * @Autowired 
	 * public void setDependency2(Dependency2 dependency2) {
	 * 	System.out.println("Setter Injection - setDependency2"); this.dependency2 =
	 * dependency2; }
	 */

	


	public String toString() {
		return "Using " + dependency + " and " + dependency2;
	}
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication2 {
	
	public static void main(String[] args) {
		// use spring
		try(var context = 
				new AnnotationConfigApplicationContext(DepInjectionLauncherApplication2.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
		}
	}

}

// 1. configuration
// 2. component to interfaces or the classes (objects) that u want spring framework to create for us
// 3. and then component scan the packages
// 4. what would happen if we have multiple component
// - then we can use primary or qua lifier to avoid any multiple beans being selected