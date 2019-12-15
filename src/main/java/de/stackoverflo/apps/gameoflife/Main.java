package de.stackoverflo.apps.gameoflife;

public class Main {

    public static void main(String[] args) {
        GameOfLifeSimulation simulation = new GameOfLifeSimulation(new GameOfLifeAutomaton());
        simulation.startRandomState();
    }

}
