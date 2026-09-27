package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a position on a Battleship board.
 *
 * <p>A position is identified by its row and column and records whether
 * it is occupied and whether it has been hit.</p>
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Creates a position with the specified row and column.
     *
     * @param row the row coordinate
     * @param column the column coordinate
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row coordinate of this position.
     *
     * @return the row coordinate
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column coordinate of this position.
     *
     * @return the column coordinate
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Returns the hash code of this position.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Determines whether another object represents a position with the same
     * row and column coordinates.
     *
     * @param otherPosition the object to compare with this position
     * @return {@code true} if both positions have the same coordinates;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Determines whether another position is adjacent to this position.
     *
     * @param other the position to check
     * @return {@code true} if the position is adjacent;
     *         {@code false} otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as hit.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Determines whether this position is occupied.
     *
     * @return {@code true} if the position is occupied;
     *         {@code false} otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Determines whether this position has been hit.
     *
     * @return {@code true} if the position has been hit;
     *         {@code false} otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a textual representation of this position.
     *
     * @return a string containing the row and column
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}