package de.unistuttgart.iste.sqa.pse.tictactoe;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;

/**
 * A wrapper around a Hamster that offers additional useful operations to move
 * around the Territory.
 */
public class TicTacToeHamster {
	private final Hamster hamster;
	private final SymbolDrawer drawingStrategy;

	public TicTacToeHamster(final Hamster hamster, final SymbolDrawer drawingStrategy) {
		super();
		this.hamster = hamster;
		this.drawingStrategy = drawingStrategy;
	}

	/**
	 * moves the hamster to the target Location, facing east
	 *
	 * @param targetLocation the destination for the Hamster to move to.
	 * @requires targetLocation must be on the territory
	 * @ensures hamster.getLocation() == targetLocation
	 * @ensures hamster.getDirection() == Direction.EAST
	 */
	public void moveToLocation(final Location targetLocation) {
		Direction horizontalDirection = Direction.EAST;
		if (hamster.getLocation().getColumn() > targetLocation.getColumn()) {
			horizontalDirection = Direction.WEST;
		}
		Direction verticalDirection = Direction.SOUTH;
		if (hamster.getLocation().getRow() > targetLocation.getRow()) {
			verticalDirection = Direction.NORTH;
		}

		turnToDirection(verticalDirection);
		while (hamster.getLocation().getRow() != targetLocation.getRow()) {
			hamster.move();
		}

		turnToDirection(horizontalDirection);
		while (hamster.getLocation().getColumn() != targetLocation.getColumn()) {
			hamster.move();
		}
		turnToDirection(Direction.EAST);
	}

	/**
	 * draws this hamster's associated symbol as defined by its drawingStrategy
	 */
	public void draw() {
		drawingStrategy.drawPlayerSymbol(this);
	}

	/**
	 * @see de.hamstersimulator.objectsfirst.external.model.Hamster#mouthEmpty()
	 */
	public boolean mouthEmpty() {
		return hamster.mouthEmpty();
	}

	/**
	 * @see de.hamstersimulator.objectsfirst.external.model.Hamster#write(String)
	 */
	public void write(final String text) {
		hamster.write(text);
	}

	/**
	 * @see de.hamstersimulator.objectsfirst.external.model.Hamster#readNumber(String)
	 */
	public int readNumber(final String number) {
		return hamster.readNumber(number);
	}

	/**
	 * @see de.hamstersimulator.objectsfirst.external.model.Hamster#move()
	 */
	public void move() {
		hamster.move();
	}

	/**
	 * @see de.hamstersimulator.objectsfirst.external.model.Hamster#turnLeft()
	 */
	public void turnLeft() {
		hamster.turnLeft();
	}

	/**
	 * the hamster puts down the entered number of grains
	 *
	 * @param grainNumber number of grains to drop
	 * @requires the hamster has enough grains in its mouth
	 */
	public void putGrains(final int grainNumber) {
		for (int i = 0; i < grainNumber; i++) {
			if (!hamster.mouthEmpty()) {
				hamster.putGrain();
			}
		}
	}

	/**
	 * turns the hamster left until it faces the entered direction
	 *
	 * @param targetDirection the direction to turn to
	 * @ensures hamster.getDirection() == targetDirection
	 */
	public void turnToDirection(final Direction targetDirection) {
		while (hamster.getDirection() != targetDirection) {
			hamster.turnLeft();
		}
	}

	/**
	 * turns the hamster to the right by turning left thrice.
	 */
	public void turnRight() {
		hamster.turnLeft();
		hamster.turnLeft();
		hamster.turnLeft();
	}
}
