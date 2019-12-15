package de.stackoverflo.apps.gameoflife;

import de.stackoverflo.libs.colorgrid.ColorGridPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * A grid in a dedicated frame that allows visualizing a cellular automaton.
 */
public class CellularGrid extends JFrame implements MouseWheelListener {

    private JLabel statusBar;
    private final Color activeCellColor;
    private ColorGridPanel colorGrid;

    public CellularGrid(String title, Color activeCellColor) {
        super(title);
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseWheelListener(this);

        this.activeCellColor = activeCellColor;

        this.colorGrid = new ColorGridPanel();
        getContentPane().add(colorGrid, BorderLayout.CENTER);

        this.statusBar = createStatusBar();
        getContentPane().add(statusBar, BorderLayout.SOUTH);
    }

    private JLabel createStatusBar() {
        JLabel statusBar = new JLabel();
        statusBar.setBackground(Color.DARK_GRAY.darker());
        statusBar.setOpaque(true);
        statusBar.setForeground(Color.GRAY.brighter());
        statusBar.setPreferredSize(new Dimension(getWidth(), 30));
        return statusBar;
    }

    /**
     * Marks the cell at the given coordinate (x,y) to be either active or inactive.
     *
     * @param x            x-coordinate of the cell
     * @param y            y-coordinate of the cell
     * @param isCellActive true if active, false otherwise
     */
    public void setCellActive(int x, int y, boolean isCellActive) {
        if (isCellActive) {
            colorGrid.setSquareColor(x, y, activeCellColor);
        } else {
            colorGrid.resetSquareColor(x, y);
        }
    }

    public void setSquareWidth(int width) {
        colorGrid.setSquareWidth(width);
    }

    public void setInactiveCellColor(Color c) {
        colorGrid.setDefaultSquareColor(c);
    }

    public void setBorderWidth(int width) {
        colorGrid.setBorderWidth(width);
    }

    public void setBorderColor(Color c) {
        colorGrid.setBackground(c);
    }

    public void setGenerationCount(int generationCount) {
        this.statusBar.setText(" Generation " + generationCount);
    }

    public int countColumns() {
        return colorGrid.countColumns();
    }

    public int countRows() {
        return colorGrid.countRows();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        setSquareWidth(colorGrid.getSquareWidth() - e.getWheelRotation());
    }
}
