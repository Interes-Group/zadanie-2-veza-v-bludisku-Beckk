package sk.stuba.fei.uim.oop.Maze;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class MazeClass {

    public void PrintMaze()
    {
        for (int i = 0; i < height; i++)
        {
            for(int k = 0; k < 3; k++)
            {
                if(k == 0)
                {
                    for(int j = 0; j < weight; j++)
                    {
                        System.out.print("#");
                        if(maze[i][j].getWall()[0])
                            System.out.print("#");
                        else
                            System.out.print(".");
                        System.out.print("#");
                    }
                    System.out.print("\n");
                }
                else if(k == 1){
                    for(int j = 0; j < weight; j++)
                    {
                        if(maze[i][j].getWall()[1])
                            System.out.print("#");
                        else
                            System.out.print(".");
                        System.out.print(".");
                        if(maze[i][j].getWall()[2])
                            System.out.print("#");
                        else
                            System.out.print(" ");

                    }
                    System.out.print("\n");
                }else {
                    /*for(int j = 0; j < weight; j++)
                    {
                        System.out.print("#");
                        if(maze[i][j].getWall()[3])
                            System.out.print("#");
                        else
                            System.out.print(".");
                        System.out.print("#");
                    }*/
                }
            }
        }
    }
    public MazeClass(int height,int weight)
    {
        this.weight = weight;
        this.height = height;
        maze = new CellClass[height][weight];
        for(int i = 0; i < height;i++)
        {
            for(int j = 0; j < weight;j++)
            {
                maze[i][j] = new CellClass(i,j);
            }
        }
        GenerateCellConnections();
        RandomizedDFS(maze[0][0]);
        //PrintMaze();
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public CellClass getCell(int i,int j)
    {
        return maze[i][j];
    }
    private CellClass[][] maze;
    private int height;
    private int weight;
    private void GenerateCellConnections()
    {
        for(int i = 0; i < height;i++) {
            for (int j = 0; j < weight; j++) {
                //UpperCell
                if(i - 1 < 0)
                {
                    maze[i][j].setUpCell(null);
                }else
                {
                    maze[i][j].setUpCell(maze[i-1][j]);
                }
                //DownCell
                if(i + 1 >= height)
                {
                    maze[i][j].setDownCell(null);
                }else
                {
                    maze[i][j].setDownCell(maze[i+1][j]);
                }
                //leftCell
                if(j - 1 < 0)
                {
                    maze[i][j].setLeftCell(null);
                }else
                {
                    maze[i][j].setLeftCell(maze[i][j-1]);
                }
                //rightCell
                if(j + 1 >= weight)
                {
                    maze[i][j].setRightCell(null);
                }else
                {
                    maze[i][j].setRightCell(maze[i][j+1]);
                }
            }
        }
    }
    private void RandomizedDFS(CellClass cell)
    {
        cell.MarkVisited();
        CellClass nextCell = randomUnvisitedNeighbour(cell);
        while (nextCell != null) {
            if (nextCell == null)
                return;
            cell.ConnectToCell(nextCell);
            nextCell.ConnectToCell(cell);
            RandomizedDFS(nextCell);
            nextCell = randomUnvisitedNeighbour(cell);
        }

    }

    private CellClass randomUnvisitedNeighbour(CellClass cellClass)
    {
        ArrayList<CellClass> posibleCell = new ArrayList<>();

        CellClass upCell = cellClass.getUpCell();
        if(isCellPosible(upCell))
            posibleCell.add(upCell);
        CellClass downCell = cellClass.getDownCell();
        if(isCellPosible(downCell))
            posibleCell.add(downCell);
        CellClass leftCell = cellClass.getLeftCell();
        if(isCellPosible(leftCell))
            posibleCell.add(leftCell);
        CellClass rightCell = cellClass.getRightCell();
        if(isCellPosible(rightCell))
            posibleCell.add(rightCell);
        if(posibleCell.size() > 0)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, posibleCell.size());
            return posibleCell.get(randomNum);

        }
        else
        {
            return null;
        }
    }

    private Boolean isCellPosible(CellClass candidateCell)
    {
        if(candidateCell != null)
        {
            if(!candidateCell.IsVisited())
            {
                return true;
            }
        }
        return false;
    }
}

