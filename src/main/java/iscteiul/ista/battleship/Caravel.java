package iscteiul.ista.battleship;

/**
 * Represents a Caravel in the Battleship game ("Age of Discoveries" version).
 * <p>
 * The Caravel corresponds to the "2-gun ship" of the traditional version,
 * occupying two consecutive cells on the board, either horizontally or
 * vertically, starting from an initial position. Each fleet must contain
 * three caravels, according to the game specification.
 *
 * @author (your name here)
 * @see Ship
 */
public class Caravel extends Ship {

    /**
     * Fixed size of the Caravel: it always occupies two cells on the board.
     */
    private static final Integer SIZE = 2;

    /**
     * Name of the ship, used for identification and display to the user.
     */
    private static final String NAME = "Caravela";

    /**
     * Creates a new Caravel from the given initial position, extending across
     * two cells in the direction determined by the bearing.
     * <p>
     * If the bearing is {@code NORTH} or {@code SOUTH}, the caravel occupies
     * two consecutive cells in the same column, advancing along the rows.
     * If it is {@code EAST} or {@code WEST}, it occupies two consecutive
     * cells in the same row, advancing along the columns.
     *
     * @param bearing orientation of the caravel (NORTH, SOUTH, EAST or WEST)
     * @param pos     initial position (row, column) from which the caravel is built
     * @throws NullPointerException     if {@code bearing} is {@code null}
     * @throws IllegalArgumentException if {@code bearing} has an unsupported value
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Returns the size of the Caravel.
     *
     * @return the fixed value {@code 2}, corresponding to the Caravel's size
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
