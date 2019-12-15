package de.stackoverflo.libs.colorgrid;

import java.util.Objects;

public class ColorCoordinate {

    private int x;
    private int y;

    public ColorCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorCoordinate that = (ColorCoordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
