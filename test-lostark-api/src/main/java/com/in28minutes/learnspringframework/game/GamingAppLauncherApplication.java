package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
		// use spring
		try(var context = 
				new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
			
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}

}

// 1. configuration
// 2. component to interfaces or the classes (objects) that u want spring framework to create for us
// 3. and then component scan the packages
// 4. what would happen if we have multiple component
// - then we can use primary or qualifier to avoid any multiple beans being selected