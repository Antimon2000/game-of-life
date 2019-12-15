package de.stackoverflo.apps.gameoflife;

import java.awt.*;

public class CellularSimulation {

    private CellularGrid cellularGrid;
    private CellularAutomaton gameOfLifeAutomaton;
    private int evolutionDelay; // milliseconds

    public CellularSimulation(CellularAutomaton cellularAutomaton, Color activeCellColor) {
        if (cellularAutomaton == null) {
            throw new IllegalArgumentException("please provide an implementation of a cellular automaton");
        }

        this.cellularGrid = new CellularGrid(cellularAutomaton.getClass().getName(), activeCellColor);
        this.gameOfLifeAutomaton = cellularAutomaton;

        this.evolutionDelay = 100;
        this.cellularGrid.setSquareWidth(10);
        this.cellularGrid.setVisible(true);
    }

    public void startRandomState() {
        createRandomState(20, 20, 200, 150, 0.4);
        start();
    }

    public void setCellActive(int x, int y) {
        gameOfLifeAutomaton.setCellState(x, y, true);
    }

    public void start() {
        int generationNumber = 1;
        while (true) {
            showGeneration(generationNumber);
            gameOfLifeAutomaton.evolve();
            generationNumber++;

            try {
                Thread.sleep(evolutionDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showGeneration(int generationNumber) {
        final int visibleCols = cellularGrid.countColumns();
        final int visibleRows = cellularGrid.countRows();

        for (int cols = 0; cols < visibleCols; cols++) {
            for (int rows = 0; rows < visibleRows; rows++) {
                cellularGrid.setCellActive(cols, rows, gameOfLifeAutomaton.isCellActive(cols, rows));
            }
        }

        cellularGrid.repaint();
        cellularGrid.setGenerationCount(generationNumber);
    }

    private void createRandomState(int xPos, int yPos, int width, int height, double activityLikelihood) {
        for (int x = xPos; x < width + xPos; x++) {
            for (int y = yPos; y < height + yPos; y++) {
                if (Math.random() < activityLikelihood) {
                    setCellActive(x, y);
                }
            }
        }
    }

}
