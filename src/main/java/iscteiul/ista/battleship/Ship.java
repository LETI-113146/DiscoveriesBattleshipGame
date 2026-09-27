/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Provides the common state and behavior of ships in a Battleship game.
 *
 * <p>Each ship has a category, a bearing, a reference position, and a list
 * of board positions that it occupies.</p>
 */
public abstract class Ship implements IShip {

    /**
     * Category identifier used to create a galleon.
     */
    private static final String GALEAO = "galeao";

    /**
     * Category identifier used to create a frigate.
     */
    private static final String FRAGATA = "fragata";

    /**
     * Category identifier used to create a carrack.
     */
    private static final String NAU = "nau";

    /**
     * Category identifier used to create a caravel.
     */
    private static final String CARAVELA = "caravela";

    /**
     * Category identifier used to create a barge.
     */
    private static final String BARCA = "barca";

    /**
     * @param shipKind
     * @param bearing
     * @param pos
     * @return
     */
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


    /**
     * The ship's category.
     */
    private String category;

    /**
     * The direction in which the ship is oriented.
     */
    private Compass bearing;

    /**
     * The ship's reference position.
     */
    private IPosition pos;

    /**
     * The board positions occupied by the ship.
     */
    protected List<IPosition> positions;


    /**
     * @param category
     * @param bearing
     * @param pos
     */
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

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getCategory()
     */
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
     * @return the positions
     */
    /**
     * Returns the board positions occupied by the ship.
     *
     * @return the ship's occupied positions
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getPosition()
     */
    /**
     * Returns the ship's reference position.
     *
     * @return the reference position
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getBearing()
     */
    /**
     * Returns the direction in which the ship is oriented.
     *
     * @return the ship's bearing
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#stillFloating()
     */
    /**
     * Determines whether at least one position occupied by the ship has not
     * been hit.
     *
     * @return {@code true} if the ship is still floating;
     *         {@code false} if all its positions have been hit
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getTopMostPos()
     */
    /**
     * Returns the smallest row coordinate occupied by the ship.
     *
     * @return the ship's topmost row coordinate
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getBottomMostPos()
     */
    /**
     * Returns the largest row coordinate occupied by the ship.
     *
     * @return the ship's bottommost row coordinate
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getLeftMostPos()
     */
    /**
     * Returns the smallest column coordinate occupied by the ship.
     *
     * @return the ship's leftmost column coordinate
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getRightMostPos()
     */
    /**
     * Returns the largest column coordinate occupied by the ship.
     *
     * @return the ship's rightmost column coordinate
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#occupies(battleship.IPosition)
     */
    /**
     * Determines whether the ship occupies the specified board position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship occupies the position;
     *         {@code false} otherwise
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#tooCloseTo(battleship.IShip)
     */
    /**
     * Determines whether this ship is too close to another ship.
     *
     * @param other the other ship to check
     * @return {@code true} if any position occupied by the other ship is
     *         adjacent to this ship; {@code false} otherwise
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#tooCloseTo(battleship.IPosition)
     */
    /**
     * Determines whether a position is adjacent to any position occupied by
     * this ship.
     *
     * @param pos the position to check
     * @return {@code true} if the position is too close to the ship;
     *         {@code false} otherwise
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }


    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#shoot(battleship.IPosition)
     */
    /**
     * Shoots at the specified position, marking it as hit if it is occupied
     * by this ship.
     *
     * @param pos the position being shot at
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }


    /**
     * Returns a textual representation of the ship.
     *
     * @return a string containing the ship's category, bearing, and reference
     *         position
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}