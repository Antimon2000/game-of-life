package de.stackoverflo.apps.gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeAutomatonTest {

    @Test
    public void givenDeadCellAndAllNeighborsDead_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }

    @Test
    public void givenLiveCellAndAllNeighborsDead_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(5, 5, true); // Cell
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }

    @Test
    public void givenDeadCellAndOneNeighborAlive_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(4, 5, true); // Neighbor
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }

    @Test
    public void givenLiveCellAndOneNeighborAlive_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(5, 5, true); // Cell
        gol.setCellState(4, 5, true); // Neighbor
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }

    @Test
    public void givenDeadCellAndTwoNeighborsAlive_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(4, 5, true); // Neighbor
        gol.setCellState(6, 5, true); // Neighbor
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }

    @Test
    public void givenLiveCellAndTwoNeighborsAlive_whenEvolve_thenCellAlive() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(5, 5, true); // Cell
        gol.setCellState(4, 5, true); // Neighbor
        gol.setCellState(6, 5, true); // Neighbor
        gol.evolve();
        assertTrue(gol.isCellActive(5, 5));
    }

    @Test
    public void givenDeadCellAndThreeNeighborsAlive_whenEvolve_thenCellAlive() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(5, 4, true); // Neighbor
        gol.setCellState(4, 5, true); // Neighbor
        gol.setCellState(6, 5, true); // Neighbor
        gol.evolve();
        assertTrue(gol.isCellActive(5, 5));
    }

    @Test
    public void givenLiveCellAndThreeNeighborsAlive_whenEvolve_thenCellAlive() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(5, 5, true); // Cell
        gol.setCellState(5, 4, true); // Neighbor
        gol.setCellState(4, 5, true); // Neighbor
        gol.setCellState(6, 5, true); // Neighbor
        gol.evolve();
        assertTrue(gol.isCellActive(5, 5));
    }

    @Test
    public void givenDeadCellAndFourNeighborsAlive_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(4, 4, true); // Neighbor
        gol.setCellState(6, 4, true); // Neighbor
        gol.setCellState(4, 6, true); // Neighbor
        gol.setCellState(6, 6, true); // Neighbor
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }

    @Test
    public void givenLiveCellAndFourNeighborsAlive_whenEvolve_thenCellDead() {
        GameOfLifeAutomaton gol = new GameOfLifeAutomaton();
        gol.setCellState(5, 5, true); // Cell
        gol.setCellState(4, 4, true); // Neighbor
        gol.setCellState(6, 4, true); // Neighbor
        gol.setCellState(4, 6, true); // Neighbor
        gol.setCellState(6, 6, true); // Neighbor
        gol.evolve();
        assertFalse(gol.isCellActive(5, 5));
    }
}