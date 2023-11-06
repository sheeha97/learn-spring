package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App03AppGamingSpringBeans {

	public static void main(String[] args) {
		// use spring
		try(var context = 
				new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
			// create objects for us
			// currently we are creating the objects by ourselves
			
			
		}
	}

}
