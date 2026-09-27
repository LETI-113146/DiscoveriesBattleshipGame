/**
 * Provides the common state and behavior of ships in a Battleship game.
 *
 * <p>Each ship has a category, a bearing, a reference position, and a list
 * of board positions that it occupies.</p>
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Creates a ship of the requested category.
     *
     * @param shipKind the category of ship to create
     * @param bearing the direction in which the ship is oriented
     * @param pos the ship's reference position
     * @return the created ship, or {@code null} if the category is unknown
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }


    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;


    /**
     * Creates a ship with the specified category, bearing, and reference
     * position.
     *
     * @param category the ship's category
     * @param bearing the direction in which the ship is oriented
     * @param pos the ship's reference position
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Returns the ship's category.
     *
     * @return the ship category
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the board positions occupied by the ship.
     *
     * @return the ship's occupied positions
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Returns the ship's reference position.
     *
     * @return the reference position
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Returns the direction in which the ship is oriented.
     *
     * @return the ship's bearing
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Determines whether at least one position occupied by the ship has not
     * been hit.
     *
     * @return {@code true} if the ship is still floating; {@code false} if
     *         all its positions have been hit
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
