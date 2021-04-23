<<<<<<< Updated upstream
package sk.stuba.fei.uim.oop.UI;

import sk.stuba.fei.uim.oop.Maze.CellClass;
import sk.stuba.fei.uim.oop.Maze.MazeClass;

import java.util.ArrayList;

public class WallList {
    public ArrayList<Wall> wallArrayList = new ArrayList<>();
    public int w = 40;

    public void AddCellToList(CellClass cell)
    {
        if(cell.getWall()[0])
        {
            wallArrayList.add(new Wall(cell.getJ()*w,(cell.getJ()+1)*w,cell.getI()*w, cell.getI()*w) );
        }
        if(cell.getWall()[1])
        {
            wallArrayList.add(new Wall((cell.getJ()*w),cell.getJ()*w,cell.getI()*w, (cell.getI()+1)*w) );
        }
        if(cell.getWall()[2])
        {
            wallArrayList.add(new Wall((cell.getJ()+1)*w,(cell.getJ()+1)*w,cell.getI()*w, (cell.getI()+1)*w) );
        }
        if(cell.getWall()[3])
        {
            wallArrayList.add(new Wall(cell.getJ()*w,(cell.getJ()+1)*w,(cell.getI()+1)*w, (cell.getI() + 1)*w) );
        }
    }
    public void InsertArray(MazeClass mazeClass)
    {
        wallArrayList.clear();
        for(int i = 0; i < mazeClass.getHeight();i++ )
        {
            for(int j = 0; j < mazeClass.getWeight();j++)
            {
                AddCellToList(mazeClass.getCell(i,j));
            }
        }
    }
}
=======
package sk.stuba.fei.uim.oop.UI;

import sk.stuba.fei.uim.oop.Maze.CellClass;
import sk.stuba.fei.uim.oop.Maze.MazeClass;

import java.util.ArrayList;

public class WallList {
    public ArrayList<Wall> wallArrayList = new ArrayList<>();
    public int w = 40;

    public void AddCellToList(CellClass cell)
    {
        if(cell.getWall()[0])
        {
            wallArrayList.add(new Wall(cell.getJ()*w,(cell.getJ()+1)*w,cell.getI()*w, cell.getI()*w) );
        }
        if(cell.getWall()[1])
        {
            wallArrayList.add(new Wall((cell.getJ()*w),cell.getJ()*w,cell.getI()*w, (cell.getI()+1)*w) );
        }
        if(cell.getWall()[2])
        {
            wallArrayList.add(new Wall((cell.getJ()+1)*w,(cell.getJ()+1)*w,cell.getI()*w, (cell.getI()+1)*w) );
        }
        if(cell.getWall()[3])
        {
            wallArrayList.add(new Wall(cell.getJ()*w,(cell.getJ()+1)*w,(cell.getI()+1)*w, (cell.getI() + 1)*w) );
        }
    }
    public void InsertArray(MazeClass mazeClass)
    {
        wallArrayList.clear();
        for(int i = 0; i < mazeClass.getHeight();i++ )
        {
            for(int j = 0; j < mazeClass.getWeight();j++)
            {
                AddCellToList(mazeClass.getCell(i,j));
            }
        }
    }
}
>>>>>>> Stashed changes
