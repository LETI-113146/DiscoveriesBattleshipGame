package iscteiul.ista.battleship;

import java.util.List;

/**
 * Represents the collection of ships that a player places on the game board.
 * A fleet provides operations for adding ships, finding ships by category or
 * position, and inspecting their current state.
 */
public interface IFleet {
    /** The width and height of the square game board. */
    Integer BOARD_SIZE = 10;
    
    /** The maximum number of ships in a fleet. */
    Integer FLEET_SIZE = 10;

    /**
     * Returns the ships in this fleet.
     *
     * @return the list of ships in the fleet
     */
    List<IShip> getShips();

    /**
     * Adds a ship to this fleet if it can be placed on the board without being
     * too close to another ship.
     *
     * @param s the ship to add
     * @return {@code true} if the ship was added; {@code false} otherwise
     */
    boolean addShip(IShip s);

    /**
     * Returns all ships belonging to the specified category.
     *
     * @param category the category to search for
     * @return a list containing the ships in the requested category
     */
    List<IShip> getShipsLike(String category);

    /**
     * Returns the ships that have not sunk.
     *
     * @return a list containing all ships that are still floating
     */
    List<IShip> getFloatingShips();

    /**
     * Finds the ship occupying the specified position.
     *
     * @param pos the board position to inspect
     * @return the ship occupying {@code pos}, or {@code null} if the position
     *         is not occupied by a ship in this fleet
     */
    IShip shipAt(IPosition pos);

    /**
     * Prints a summary of the fleet's current state.
     */
    void printStatus();
}
