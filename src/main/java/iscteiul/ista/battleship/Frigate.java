package iscteiul.ista.battleship;

/**
 * Represents a frigate in the fleet.
 * A frigate occupies four consecutive positions, arranged vertically when its
 * bearing is north or south and horizontally when its bearing is east or west.
 *
 * @see Ship
 */
public class Frigate extends Ship {
    /** The number of board positions occupied by a frigate. */
    private static final Integer SIZE = 4;

    /** The category name used to identify a frigate. */
    private static final String NAME = "Fragata";

    /**
     * Creates a frigate starting at the specified position.
     *
     * @param bearing the orientation of the frigate
     * @param pos     the initial position used to place the frigate
     * @throws NullPointerException     if {@code bearing} or {@code pos} is
     *                                  {@code null}
     * @throws IllegalArgumentException if {@code bearing} is not a supported
     *                                  direction
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Returns the number of positions occupied by the frigate.
     *
     * @return the fixed frigate size of {@code 4}
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
