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

	public TicTacToeHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
		this.grid = new TicTacToeGrid();
		game.setSpeed(10.00); // Auto Speed Up the game
	}

	@Override
	protected void run() {
	}
}
