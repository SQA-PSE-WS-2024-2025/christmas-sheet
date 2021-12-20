package de.unistuttgart.iste.sqa.pse.tiktaktoe;

import java.util.Optional;

import de.hamstersimulator.objectsfirst.datatypes.Location;

/**
 * This class represents a single Area on the Tic-Tac-Toe Grid.
 */
public class Area {
	private final Location location;

	/**
	 * create a new Area with the given Location as its 'start location', i.e. its
	 * top-left tile
	 *
	 * @param startLocation the Area's start location
	 */
	public Area(final Location startLocation) {
		super();
		this.location = startLocation;
	}

	/**
	 * @return this Area's start location, i.e. its top-left tile
	 */
	public Location getLocation() {
		return location;
	}

}
