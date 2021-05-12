package sk.stuba.fei.uim.oop.Maze;

public class CellClass {
    public CellClass(int i, int j) {
        wall = new Boolean[]{true,true,true,true};
        isVisited = false;
        this.i = i;
        this.j = j;
    }

    public CellClass getUpCell() {
        return upCell;
    }

    public CellClass getDownCell() {
        return downCell;
    }

    public CellClass getLeftCell() {
        return leftCell;
    }

    public CellClass getRightCell() {
        return rightCell;
    }

    public void setUpCell(CellClass upCell) {
        this.upCell = upCell;
    }

    public void setDownCell(CellClass downCell) {
        this.downCell = downCell;
    }

    public void setLeftCell(CellClass leftCell) {
        this.leftCell = leftCell;
    }

    public void setRightCell(CellClass rightCell) {
        this.rightCell = rightCell;
    }
    public Boolean[] getWall() {
        return wall;
    }
    public void MarkVisited()
    {
        isVisited = true;
    }
    public Boolean IsVisited()
    {
        return isVisited;
    }

    public void ConnectToCell(CellClass cellToConnect)
    {
        if(upCell == cellToConnect)
        {
            wall[0] = false;
            return;
        }
        if(leftCell == cellToConnect)
        {
            wall[1] = false;
            return;
        }
        if(rightCell == cellToConnect)
        {
            wall[2] = false;
            return;
        }
        if(downCell == cellToConnect)
        {
            wall[3] = false;
            return;
        }
        if(cellToConnect.getI() < i)
        {
            wall[0] = false;
            return;
        }
        if(cellToConnect.getJ() < j)
        {
            wall[1] = false;
            return;
        }
        if (cellToConnect.getJ() > j)
        {
            wall[2] = false;
            return;
        }
        if(cellToConnect.getI() > i)
        {
            wall[3] = false;
            return;
        }
        System.out.println("No connection");
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    private CellClass upCell;
    private CellClass downCell;
    private CellClass leftCell;
    private CellClass rightCell;
    private Boolean isVisited;
    private int i,j;
    private Boolean[] wall;//true is wall;false no wakll
    /*
        [0]
    [1]    [2]
        [3]
     */
}
