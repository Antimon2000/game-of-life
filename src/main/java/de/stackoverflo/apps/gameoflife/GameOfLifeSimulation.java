package de.stackoverflo.apps.gameoflife;

import java.awt.*;

public class GameOfLifeSimulation {

    private CellularSimulation simulation;

    public GameOfLifeSimulation(CellularAutomaton gameOfLifeAutomaton) {
        this.simulation = new CellularSimulation(gameOfLifeAutomaton, Color.ORANGE);
    }

    public void startRandomState() {
        this.simulation.startRandomState();
    }

    public void startGliderGun() {
        createFigureGosperGliderGun(10, 10);
        this.simulation.start();
    }

    public void startSmallExploder() {
        createFigureSmallExploder(10, 10);
        this.simulation.start();
    }

    private void createFigureSmallExploder(int x, int y) {
        this.simulation.setCellActive(x + 1, y);
        this.simulation.setCellActive(x, y + 1);
        this.simulation.setCellActive(x + 1, y + 1);
        this.simulation.setCellActive(x + 2, y + 1);
        this.simulation.setCellActive(x, y + 2);
        this.simulation.setCellActive(x + 2, y + 2);
        this.simulation.setCellActive(x + 1, y + 3);
    }

    private void createFigureGosperGliderGun(int x, int y) {
        createFigure1(x, y + 2);
        createFigure1(x + 34, y);
        createFigure2(x + 8, y + 2);
        createFigure2(x + 22, y);
        createFigure3(x + 16, y + 4);
        createFigure3(x + 35, y + 7);
        createFigure4(x + 24, y + 12);
    }

    private void createFigure1(int x, int y) {
        this.simulation.setCellActive(x, y);
        this.simulation.setCellActive(x + 1, y);
        this.simulation.setCellActive(x, y + 1);
        this.simulation.setCellActive(x + 1, y + 1);
    }

    private void createFigure2(int x, int y) {
        this.simulation.setCellActive(x + 1, y);
        this.simulation.setCellActive(x + 2, y);
        this.simulation.setCellActive(x, y + 1);
        this.simulation.setCellActive(x + 2, y + 1);
        this.simulation.setCellActive(x, y + 2);
        this.simulation.setCellActive(x + 1, y + 2);
    }

    private void createFigure3(int x, int y) {
        this.simulation.setCellActive(x, y);
        this.simulation.setCellActive(x + 1, y);
        this.simulation.setCellActive(x, y + 1);
        this.simulation.setCellActive(x + 2, y + 1);
        this.simulation.setCellActive(x, y + 2);
    }

    private void createFigure4(int x, int y) {
        this.simulation.setCellActive(x, y);
        this.simulation.setCellActive(x + 1, y);
        this.simulation.setCellActive(x + 2, y);
        this.simulation.setCellActive(x, y + 1);
        this.simulation.setCellActive(x + 1, y + 2);
    }
}
