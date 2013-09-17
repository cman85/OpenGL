
package com.github.cman85.Game.Main;


public class Main {

	private static Main main;
	private static Game game;
	
	private Main(){
		setGame(new Game());
	}
		
	public static void main(String[] args) {
		Main.setMain(new Main());
	}

	public static Main getMain() {
		return main;
	}

	public static void setMain(Main main) {
		Main.main = main;
	}

	public static Game getGame() {
		return game;
	}

	public static void setGame(Game game) {
		Main.game = game;
	}

}
