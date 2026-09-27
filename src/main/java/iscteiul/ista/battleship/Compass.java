/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Represents the possible orientations (compass directions) for placing
 * a ship on the Battleship board.
 * <p>
 * Each orientation is associated with an identifying character, used for
 * example when reading/writing fleet configurations to a text file
 * (north = 'n', south = 's', east = 'e', west = 'o'). The {@code UNKNOWN}
 * value represents an invalid or unrecognized orientation.
 *
 * @author fba
 */
public enum Compass {
    /** North orientation, identified by the character {@code 'n'}. */
    NORTH('n'),
    /** South orientation, identified by the character {@code 's'}. */
    SOUTH('s'),
    /** East orientation, identified by the character {@code 'e'}. */
    EAST('e'),
    /** West orientation, identified by the character {@code 'o'}. */
    WEST('o'),
    /** Unknown or invalid orientation, identified by the character {@code 'u'}. */
    UNKNOWN('u');

    /**
     * Character that identifies this orientation.
     */
    private final char c;

    /**
     * Creates an enum constant associated with the given character.
     *
     * @param c character identifying the orientation
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Returns the character identifying this orientation.
     *
     * @return the character associated with the orientation (e.g. {@code 'n'} for NORTH)
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the textual representation of this orientation, corresponding
     * to its identifying character.
     *
     * @return a {@code String} with a single character, equal to the value returned by {@link #getDirection()}
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts a character into the corresponding {@code Compass} constant.
     *
     * @param ch character to convert ({@code 'n'}, {@code 's'}, {@code 'e'} or {@code 'o'})
     * @return the orientation corresponding to the character, or {@link #UNKNOWN} if
     *         the character does not correspond to any valid orientation
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}