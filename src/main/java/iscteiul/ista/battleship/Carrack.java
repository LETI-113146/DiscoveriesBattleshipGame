package iscteiul.ista.battleship;

/**
 * Represents a Carrack in the Battleship game ("Age of Discoveries" version).
 * <p>
 * The Carrack corresponds to the "3-gun ship" of the traditional version,
 * occupying three consecutive cells on the board, either horizontally or
 * vertically, starting from an initial position. Each fleet must contain
 * two carracks, according to the game specification.
 *
 * @author (your name here)
 * @see Ship
 */
public class Carrack extends Ship {

    /**
     * Fixed size of the Carrack: it always occupies three cells on the board.
     */
    private static final Integer SIZE = 3;

    /**
     * Name of the ship, used for identification and display to the user.
     */
    private static final String NAME = "Nau";

    /**
     * Creates a new Carrack from the given initial position, extending across
     * three cells in the direction determined by the bearing.
     * <p>
     * If the bearing is {@code NORTH} or {@code SOUTH}, the carrack occupies
     * three consecutive cells in the same column, advancing along the rows.
     * If it is {@code EAST} or {@code WEST}, it occupies three consecutive
     * cells in the same row, advancing along the columns.
     *
     * @param bearing orientation of the carrack (NORTH, SOUTH, EAST or WEST)
     * @param pos     initial position (row, column) from which the carrack is built
     * @throws IllegalArgumentException if {@code bearing} has an unsupported value
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Returns the size of the Carrack.
     *
     * @return the fixed value {@code 3}, corresponding to the Carrack's size
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}
