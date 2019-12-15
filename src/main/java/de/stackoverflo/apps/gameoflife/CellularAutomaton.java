package de.stackoverflo.apps.gameoflife;

public interface CellularAutomaton {

    /**
     * Determines if a cell is active or inactive.
     *
     * @param x The cell's x coordinate.
     * @param y The cell's y coordinate.
     * @return {@code true} if cell is active, {@code false} otherwise.
     */
    boolean isCellActive(int x, int y);

    /**
     * Sets a cell's current state.
     *
     * @param x      The cell's x coordinate.
     * @param y      The cell's y coordinate.
     * @param {@code true} if cell shall be active, {@code false} otherwise.
     */
    void setCellState(int x, int y, boolean isCellActive);

    /**
     * Triggers this automaton's evolution step such that {@code isCellActive(int,int)} reflects the cell
     * states of the next generation.
     */
    void evolve();

}
