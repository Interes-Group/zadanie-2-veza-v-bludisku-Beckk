package sk.stuba.fei.uim.oop.MouseControl;

import sk.stuba.fei.uim.oop.Maze.CellClass;

public class possiblePosition {
    private CellClass cell;
    private int x,y;
    public int w = 40;
    public possiblePosition(CellClass cell) {
        this.cell = cell;
        x = cell.getJ() * w;
        y = cell.getI() * w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellClass getCell() {
        return cell;
    }
}
