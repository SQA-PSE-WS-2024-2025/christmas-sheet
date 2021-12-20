package de.unistuttgart.iste.sqa.pse.tiktaktoe;

import java.util.ArrayList;
import java.util.List;

import de.hamstersimulator.objectsfirst.datatypes.Location;

/**
 * This class represents the actual Tic-Tac-Toe board, consisting of multiple
 * Areas. It offers operations to convert from Areas to territory locations to
 * integrate the Grid into the Hamsterworld.
 */
public class Grid {
	private static final int TOTAL_ROW_NUMBER = 3;
	private static final int TOTAL_COLUMN_NUMBER = 3;
	private static final int AREA_ROW_FIELD_SIZE = 3;
	private static final int AREA_COLUMN_FIELD_SIZE = 3;
	private static final int GRID_SEPARATOR_FIELD_SIZE = 1;

	private final List<Area> areas = new ArrayList<>();

	public Grid() {
		super();
		generateAreas();
	}

	/**
	 * sets up the Grid with Areas depending on the size.
	 */
	private void generateAreas() {
		for (int currentAreaNumber = 0; currentAreaNumber < TOTAL_ROW_NUMBER
				* TOTAL_COLUMN_NUMBER; currentAreaNumber++) {
			final Location areaLocation = areaToTerritoryLocation(currentAreaNumber);
			final Area area = new Area(areaLocation);
			this.areas.add(area);
		}
	}

	/**
	 * convert an area number into a Location that corresponds to the top left tile
	 * of the Area
	 *
	 * @param areaNr an int between 0 and 8, numbered by rows then columns (0 is top
	 *               left, 4 is center)
	 * @return a Location object of the top left tile of the Area associated with
	 *         the areaNr
	 * @requires areaNumberExists(areaNr)
	 */
	private Location areaToTerritoryLocation(final int areaNr) {
		assert (areaNr >= 0);
		assert (areaNr < TOTAL_ROW_NUMBER * TOTAL_COLUMN_NUMBER);

		final int areaRow = (int) Math.floor((float) areaNr / TOTAL_COLUMN_NUMBER);
		final int areaColumn = areaNr % TOTAL_COLUMN_NUMBER;

		return areaToTerritoryLocation(areaRow, areaColumn);
	}

	/**
	 * given an Area's row and column on the Tic-Tac-Toe Grid, returns the Location
	 * that corresponds to the top left tile of the Area
	 *
	 * @param areaRow    the row of the Area, between 0 and 2
	 * @param areaColumn the column of the Area, between 0 and 2
	 * @return a Location object indicating the top left corner of the area on the
	 *         tic-tac-toe board
	 * @requires 0 <= areaRow < TOTAL_ROW_NUMBER
	 * @requires 0 <= areaColumn < TOTAL_COLUMN_NUMBER
	 */
	private Location areaToTerritoryLocation(final int areaRow, final int areaColumn) {
		assert areaRow > 0 && areaRow < TOTAL_ROW_NUMBER;
		assert areaColumn > 0 && areaColumn < TOTAL_COLUMN_NUMBER;

		final int row = 1 + (GRID_SEPARATOR_FIELD_SIZE + AREA_ROW_FIELD_SIZE) * areaRow;
		final int column = 1 + (GRID_SEPARATOR_FIELD_SIZE + AREA_COLUMN_FIELD_SIZE) * areaColumn;

		return new Location(row, column);
	}

	/**
	 * returns the Area object associated with the given areaNr
	 *
	 * @param areaNr the Area's number on the Grid
	 * @return the Area
	 * @requires 0 < areaNr < areas.size()
	 */
	public Area getArea(final int areaNr) {
		if (areaNr < 0 || areaNr >= areas.size()) {
			throw new IllegalArgumentException("The area with the following number does not exist:" + areaNr);
		}
		return areas.get(areaNr);
	}

	/**
	 * returns the Area object associated with the given row and column
	 *
	 * @param areaRow    the Area's row
	 * @param areaColumn the Area's column
	 * @return the Area
	 * @requires 0 <= areaRow < TOTAL_ROW_NUMBER
	 * @requires 0 <= areaColumn < TOTAL_COLUMN_NUMBER
	 */
	public Area getArea(final int areaRow, final int areaColumn) {
		if (!(areaRow > 0 && areaRow < TOTAL_ROW_NUMBER)) {
			throw new IllegalArgumentException("areaRow not on the Grid");
		}
		if (!(areaColumn > 0 && areaColumn < TOTAL_COLUMN_NUMBER)) {
			throw new IllegalArgumentException("areaColumn not on the Grid");
		}
		final int areaNr = areaRow * TOTAL_COLUMN_NUMBER + areaColumn;
		return getArea(areaNr);
	}

	/**
	 * returns an Area's row on the Grid
	 *
	 * @param area the Area
	 * @return the row on the Grid
	 * @requires areas.contains(area)
	 */
	private int getRowOfArea(final Area area) {
		assert areas.contains(area);
		final int areaNr = areas.indexOf(area);
		return areaNr / TOTAL_COLUMN_NUMBER;
	}

	/**
	 * returns an Area's row on the Grid
	 *
	 * @param area the Area
	 * @return the row on the Grid
	 * @requires areas.contains(area)
	 */
	private int getColumnOfArea(final Area area) {
		assert areas.contains(area);
		final int areaNr = areas.indexOf(area);
		return areaNr % TOTAL_COLUMN_NUMBER;
	}

	/**
	 * checks if the given areaNr has a matching Area on the Grid. In the default
	 * case of a 3x3 Grid, this is equivalent to checking for 0 < areaNr < 8.
	 *
	 * @param areaNr the number to be checked for an Area
	 * @return true if the number is valid, false otherwise
	 */
	public boolean areaNumberExists(final int areaNr) {
		return areaNr >= 0 && areaNr < areas.size();
	}

}
