package iscteiul.ista.battleship;

import java.util.List;

/**
 * Represents a ship in a Battleship game.
 *
 * <p>A ship has a category, size, position, and bearing. It occupies one or
 * more board positions and can be fired upon until it is sunk.</p>
 */
public interface IShip {

    /**
     * Returns the ship's category.
     *
     * @return the ship category
     */
    String getCategory();

    /**
     * Returns the number of positions occupied by the ship.
     *
     * @return the ship size
     */
    Integer getSize();

    /**
     * Returns all board positions occupied by the ship.
     *
     * @return the ship's occupied positions
     */
    List<IPosition> getPositions();

    /**
     * Returns the ship's reference position.
     *
     * @return the ship's reference position
     */
    IPosition getPosition();

    /**
     * Returns the direction in which the ship is oriented.
     *
     * @return the ship's bearing
     */
    Compass getBearing();

    /**
     * Determines whether the ship has at least one position that has not
     * been hit.
     *
     * @return {@code true} if the ship is still floating;
     *         {@code false} if it has been sunk
     */
    boolean stillFloating();

    /**
     * Returns the uppermost coordinate occupied by the ship.
     *
     * @return the ship's uppermost coordinate
     */
    int getTopMostPos();

    /**
     * Returns the lowermost coordinate occupied by the ship.
     *
     * @return the ship's lowermost coordinate
     */
    int getBottomMostPos();

    /**
     * Returns the leftmost coordinate occupied by the ship.
     *
     * @return the ship's leftmost coordinate
     */
    int getLeftMostPos();

    /**
     * Returns the rightmost coordinate occupied by the ship.
     *
     * @return the ship's rightmost coordinate
     */
    int getRightMostPos();

    /**
     * Determines whether the ship occupies the specified board position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship occupies the position;
     *         {@code false} otherwise
     */
    boolean occupies(IPosition pos);

    /**
     * Determines whether this ship is too close to another ship according
     * to the game's placement rules.
     *
     * @param other the other ship
     * @return {@code true} if the ships are too close;
     *         {@code false} otherwise
     */
    boolean tooCloseTo(IShip other);

    /**
     * Determines whether the specified position is too close to this ship
     * according to the game's placement rules.
     *
     * @param pos the position to check
     * @return {@code true} if the position is too close to the ship;
     *         {@code false} otherwise
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Fires at the specified position, registering a hit when the ship
     * occupies that position.
     *
     * @param pos the position being fired upon
     */
    void shoot(IPosition pos);
}