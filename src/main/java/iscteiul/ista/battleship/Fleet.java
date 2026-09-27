/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's fleet of ships in the Battleship game.
 * <p>
 * Keeps the list of ships placed on the board, ensuring that new ships
 * are only added if they lie within the board's boundaries, do not
 * collide with existing ships, and do not exceed the maximum number of
 * ships allowed ({@code FLEET_SIZE}).
 *
 * @see IFleet
 * @see IShip
 */
public class Fleet implements IFleet {

    /**
     * Prints to the console the textual representation of each ship in the given list.
     *
     * @param ships the list of ships to print
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    /**
     * List of ships that make up this fleet.
     */
    private List<IShip> ships;

    /**
     * Creates a new, initially empty fleet.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Returns the list of ships in this fleet.
     *
     * @return the fleet's list of ships
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Attempts to add a new ship to the fleet.
     * <p>
     * The ship is only actually added if: the fleet has not yet reached the
     * maximum number of ships ({@code FLEET_SIZE}); the ship lies entirely
     * within the board's boundaries; and the ship is not too close to any
     * ship already present in the fleet.
     *
     * @param s the ship to add
     * @return {@code true} if the ship was successfully added, {@code false} otherwise
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Returns all ships in the fleet belonging to a given category
     * (e.g. "Galeao", "Fragata", "Nau", "Caravela", "Barca").
     *
     * @param category the desired ship category
     * @return the list of ships in the fleet belonging to that category;
     *         an empty list if no ship matches
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Returns all ships in the fleet that are still "floating", i.e. that
     * have not yet been completely sunk.
     *
     * @return the list of ships not yet sunk
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Returns the ship in the fleet that occupies the given position, if any.
     *
     * @param pos the position to check
     * @return the ship occupying that position, or {@code null} if no ship
     *         in the fleet occupies that position
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Checks whether a ship lies entirely within the board's boundaries.
     *
     * @param s the ship to check
     * @return {@code true} if all of the ship's positions lie within the
     *         board (between {@code 0} and {@code BOARD_SIZE - 1}, inclusive)
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Checks whether a ship is too close to any of the ships already present
     * in the fleet, violating the rule that ships must not touch each other.
     *
     * @param s the ship to check
     * @return {@code true} if at least one ship in the fleet is too close to
     *         the given ship, {@code false} otherwise
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }


    /**
     * This operation shows the state of a fleet
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * This operation prints all the ships of a fleet belonging to a particular
     * category
     *
     * @param category The category of ships of interest
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * This operation prints all the ships of a fleet but not yet shot
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * This operation prints all the ships of a fleet
     */
    void printAllShips() {
        printShips(ships);
    }

}
