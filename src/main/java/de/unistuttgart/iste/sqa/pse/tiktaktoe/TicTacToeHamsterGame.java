package de.unistuttgart.iste.sqa.pse.tiktaktoe;

import java.util.LinkedList;
import java.util.List;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * The hamster starts with the exact amount of grains that can be put down in a
 * game where the whole board is covered.
 */
public class TicTacToeHamsterGame extends SimpleHamsterGame {
	private final TicTacToeGrid grid;
	private TicTacToeHamster currentPlayer;
	private TicTacToeHamster otherPlayer;

	public TicTacToeHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
		this.grid = new TicTacToeGrid();
		this.currentPlayer = turnIntoTicTacToeHamster(paule);
		this.otherPlayer = createNewTicTacToeHamster();
		game.setSpeed(10.00); // Auto Speed Up the game
	}

	private TicTacToeHamster turnIntoTicTacToeHamster(final Hamster hamster) {
		// Your code for 1c (i) should be here
		return null;
	}

	private TicTacToeHamster createNewTicTacToeHamster() {
		// Your code for 1c (i) should be here
		return null;
	}

	@Override
	protected void run() {
		// Your code for 1c (ii) and (iii) and some following tasks should be here
	}
}
