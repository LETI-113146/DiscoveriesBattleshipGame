package iscteiul.ista.battleship;

/**
 * Represents a position on the Battleship board, identified by its row and column.
 * Tracks whether the position is occupied by a ship and whether it has been shot at.
 *
 * @author fba
 */
public interface IPosition {
    /**
     * Returns the row coordinate of this position.
     *
     * @return the row coordinate
     */
    int getRow();

    /**
     * Returns the column coordinate of this position.
     *
     * @return the column coordinate
     */
    int getColumn();

    /**
     * Compares this position with another object by row and column.
     * Occupation and shot status do not affect equality.
     *
     * @param other the object to compare with this position
     * @return {@code true} if the object is an {@code IPosition} with the same
     *         row and column; {@code false} otherwise, including for {@code null}
     */
    boolean equals(Object other);

    /**
     * Checks whether another position is within one row and one column of this
     * position. This includes horizontal, vertical and diagonal neighbours,
     * as well as positions with identical coordinates.
     *
     * @param other the non-null position to check
     * @return {@code true} if both coordinate differences are at most one;
     *         {@code false} otherwise
     * @throws NullPointerException if {@code other} is {@code null}
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marks this position as occupied by a ship.
     * Has no additional effect if the position is already occupied.
     */
    void occupy();

    /**
     * Marks this position as having been shot at, whether or not it is occupied.
     * Has no additional effect if the position has already been shot at.
     */
    void shoot();

    /**
     * Checks whether this position is occupied by a ship.
     *
     * @return {@code true} if occupied; {@code false} otherwise
     */
    boolean isOccupied();

    /**
     * Checks whether this position has been shot at.
     * A {@code true} result does not necessarily mean that a ship was hit.
     *
     * @return {@code true} if this position has been shot at; {@code false} otherwise
     */
    boolean isHit();
}

