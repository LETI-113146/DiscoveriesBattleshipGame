package iscteiul.ista.battleship;

/**
 * Represents a galleon in the fleet.
 * A galleon occupies five board positions in a shape determined by its
 * bearing.
 *
 * @see Ship
 */
public class Galleon extends Ship {
    /** The number of board positions occupied by a galleon. */
    private static final Integer SIZE = 5;

    /** The category name used to identify a galleon. */
    private static final String NAME = "Galeao";

    /**
     * Creates a galleon starting at the specified position.
     *
     * @param bearing the orientation that determines the galleon's shape
     * @param pos     the initial position used to place the galleon
     * @throws NullPointerException     if {@code bearing} or {@code pos} is
     *                                  {@code null}
     * @throws IllegalArgumentException if {@code bearing} is not a supported
     *                                  direction
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the number of positions occupied by the galleon.
     *
     * @return the fixed galleon size of {@code 5}
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
