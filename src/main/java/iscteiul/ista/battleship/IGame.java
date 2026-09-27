package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the operations and statistics of a Battleship game.
 * A game records valid shots, distinguishes invalid and repeated attempts,
 * and tracks hits and sunk ships in the fleet.
 */
public interface IGame {
    /**
     * Fires at a position on the board.
     *
     * @param pos the position to target
     * @return the ship sunk by this shot, or {@code null} if the shot does not
     *         sink a ship
     */
    IShip fire(IPosition pos);

    /**
     * Returns the valid, non-repeated shots fired during the game.
     *
     * @return the list of recorded shots
     */
    List<IPosition> getShots();

    /**
     * Returns the number of shots fired more than once at the same position.
     *
     * @return the number of repeated shots
     */
    int getRepeatedShots();

    /**
     * Returns the number of shots fired outside the board.
     *
     * @return the number of invalid shots
     */
    int getInvalidShots();

    /**
     * Returns the number of successful hits on ships.
     *
     * @return the number of hits
     */
    int getHits();

    /**
     * Returns the number of ships sunk during the game.
     *
     * @return the number of sunk ships
     */
    int getSunkShips();

    /**
     * Returns the number of ships that are still floating.
     *
     * @return the number of remaining ships
     */
    int getRemainingShips();

    /**
     * Prints a board showing all valid shots fired during the game.
     */
    void printValidShots();

    /**
     * Prints a board showing the positions occupied by the fleet.
     */
    void printFleet();
}
