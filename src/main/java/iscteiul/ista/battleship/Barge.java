package iscteiul.ista.battleship;

/**
 * Represents a Barge in the Battleship game ("Age of Discoveries" version).
 * <p>
 * The Barge corresponds to the "Submarine" of the traditional version,
 * occupying a single cell on the board. Each fleet must contain four
 * barges, according to the game specification.
 *
 * @author (your name here)
 * @see Ship
 */
public class Barge extends Ship {

    /**
     * Fixed size of the Barge: it always occupies a single cell on the board.
     */
    private static final Integer SIZE = 1;

    /**
     * Name of the ship, used for identification and display to the user.
     */
    private static final String NAME = "Barca";

    /**
     * Creates a new Barge at the given position.
     * <p>
     * Since the Barge has size 1, the bearing does not affect which cells
     * are occupied: the ship's only position is always the given starting
     * position.
     *
     * @param bearing orientation of the barge (horizontal or vertical)
     * @param pos     upper left position (row, column) of the barge on the board
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the Barge.
     *
     * @return the fixed value {@code 1}, corresponding to the Barge's size
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}