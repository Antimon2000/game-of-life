package de.stackoverflo.apps.gameoflife;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GameOfLifeAutomaton implements CellularAutomaton {

    private Set<Coordinate> liveCells;

    public GameOfLifeAutomaton() {
        liveCells = new HashSet<>();
    }

    @Override
    public boolean isCellActive(int x, int y) {
        return liveCells.contains(new Coordinate(x, y));
    }

    @Override
    public void setCellState(int x, int y, boolean isCellActive) {
        if (isCellActive) {
            liveCells.add(new Coordinate(x, y));
        } else {
            liveCells.remove(new Coordinate(x, y));
        }
    }

    @Override
    public void evolve() {
        Set<Coordinate> nextGenLivingCells = new HashSet<>();
        Set<Coordinate> neighbors = new HashSet<>();

        for (Coordinate c : liveCells) {

            Set<Coordinate> neighborsOfLiveCell = getNeighbors(c.getX(), c.getY());
            neighbors.addAll(neighborsOfLiveCell);

            int countNeighbors = countLiveCells(neighborsOfLiveCell);
            if (countNeighbors == 2 || countNeighbors == 3) {
                nextGenLivingCells.add(c);
            }
        }

        for (Coordinate c : neighbors) {
            Set<Coordinate> neighborNeighbors = getNeighbors(c.getX(), c.getY());
            if (countLiveCells(neighborNeighbors) == 3) {
                nextGenLivingCells.add(c);
            }
        }

        liveCells = nextGenLivingCells;
    }

    private int countLiveCells(Set<Coordinate> cells) {
        int count = 0;
        for (Coordinate c : cells) {
            count += liveCells.contains(c) ? 1 : 0;
        }
        return count;
    }

    private Set<Coordinate> getNeighbors(int x, int y) {
        Set<Coordinate> neighbors = new HashSet<>();

        neighbors.add(new Coordinate(x-1, y-1));
        neighbors.add(new Coordinate(x  , y-1));
        neighbors.add(new Coordinate(x+1, y-1));

        neighbors.add(new Coordinate(x-1, y));
        neighbors.add(new Coordinate(x+1, y));

        neighbors.add(new Coordinate(x-1, y+1));
        neighbors.add(new Coordinate(x  , y+1));
        neighbors.add(new Coordinate(x+1, y+1));

        return neighbors;
    }

    private static class Coordinate {
        private int x;
        private int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
