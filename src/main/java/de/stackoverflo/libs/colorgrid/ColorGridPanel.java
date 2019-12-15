package de.stackoverflo.libs.colorgrid;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorGridPanel extends JPanel {

    private Color defaultSquareColor;
    private Map<ColorCoordinate, Color> squareColors;
    private int squareWidth;
    private int borderWidth;

    public ColorGridPanel() {
        squareColors = new HashMap<>();
        setSquareWidth(20);
        setBorderWidth(1);
        setDefaultSquareColor(Color.DARK_GRAY);
        setBorderColor(getDefaultSquareColor().brighter());
    }

    public int getSquareWidth() {
        return this.squareWidth;
    }

    public void setSquareWidth(int width) {
        if (width > 0) {
            this.squareWidth = width;
        }
    }

    public void setBorderWidth(int width) {
        if (width > 0) {
            this.borderWidth = width;
        }
    }

    private Color getSquareColor(int x, int y) {
        return squareColors.getOrDefault(new ColorCoordinate(x,y), defaultSquareColor);
    }

    public void setSquareColor(int x, int y, Color c) {
        squareColors.put(new ColorCoordinate(x,y), c);
    }

    public Color getDefaultSquareColor() {
        return defaultSquareColor;
    }

    public void setDefaultSquareColor(Color c) {
        defaultSquareColor = c;
    }

    public void setBorderColor(Color c) {
        setBackground(c);
    }

    public void resetSquareColor(int x, int y) {
        squareColors.remove(new ColorCoordinate(x,y));
    }

    public int countColumns() {
        return divideRoundUp(getWidth(), getSquareSpace());
    }

    public int countRows() {
        return divideRoundUp(getHeight(), getSquareSpace());
    }

    private int divideRoundUp(double a, double b) {
        return (int) Math.ceil(a/b);
    }

    private int getSquareSpace() {
        return squareWidth + borderWidth;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final int panelWidth = getWidth();
        final int panelHeight = getHeight();
        final int squareSpace = getSquareSpace();

        for (int y = 0; y <= panelHeight/squareSpace; y++) {
            for (int x = 0; x <= panelWidth/squareSpace; x++) {
                int xPos = x * squareSpace;
                int yPos = y * squareSpace;

                g.setColor(getSquareColor(x,y));
                g.fillRect(xPos, yPos, squareWidth, squareWidth);
            }
        }
    }
}
