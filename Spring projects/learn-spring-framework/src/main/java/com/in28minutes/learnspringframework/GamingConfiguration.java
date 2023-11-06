package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configurable
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		return new PacmanGame();
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
	
	// var game = new MarioGame();
	// var game = new SuperContraGame();
	
	//var gameRunner = new GameRunner(game); 
	//2: Object Creation + wiring of dependencies
	// Game is a Dependency of GameRunner
	
	//gameRunner.run();
}
