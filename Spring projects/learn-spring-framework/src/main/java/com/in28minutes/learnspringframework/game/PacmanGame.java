/**
 * 
 */
package com.in28minutes.learnspringframework.game;

/**
 * 
 */
public class PacmanGame implements GamingConsole{

	@Override
	public void up() {
		System.out.println("Go UP pacman");
	}

	@Override
	public void down() {
		System.out.println("Go DOWN pacman");
		
	}

	@Override
	public void left() {
		System.out.println("Go LEFT pacman");
		
	}

	@Override
	public void right() {
		System.out.println("Go RIGHT pacman");
		
	}

}
