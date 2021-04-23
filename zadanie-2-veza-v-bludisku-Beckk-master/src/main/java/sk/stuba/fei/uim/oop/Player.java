package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Maze.CellClass;
import sk.stuba.fei.uim.oop.UI.MainUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player {
    public MainUI mainUI;
    private CellClass start,current,end;
    public int height = 10;
    public int weight = 10;
    public Player(CellClass start, CellClass end,MainUI mainUI) {
        this.start = start;
        this.current = start;
        this.end = end;
        this.mainUI = mainUI;
    }

    public void ResetPlayer(CellClass startCell)
    {
        this.start = startCell;
        this.current = startCell;
    }
    public CellClass getCurrent() {
        return current;
    }

    public CellClass getEnd() {
        return end;
    }
    public void KeyManage(KeyEvent keyEvent)
    {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
        {
            MoveUP();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
        {
            MoveLeft();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            MoveRight();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
        {
            MoveDown();
        }
    }
    public void MoveUP()
    {
        if(current.getUpCell() != null && current.getWall()[0] == false)
        {
            current = current.getUpCell();
            CheckWin();
        }
    }

    public void MoveLeft()
    {
        if(current.getLeftCell() != null && current.getWall()[1] == false)
        {
            current = current.getLeftCell();
            CheckWin();
        }
    }

    public void MoveRight()
    {
        if(current.getRightCell() != null && current.getWall()[2] == false)
        {
            current = current.getRightCell();
            CheckWin();
        }
    }

    public void MoveDown()
    {
        if(current.getDownCell() != null && current.getWall()[3] == false)
        {
            current = current.getDownCell();
            CheckWin();
        }
    }

    public void SetNewPosition(CellClass cell)
    {
        current = cell;
    }
    public void CheckWin()
    {
        mainUI.UpateUI();
        if(current == end)
        {
            mainUI.Win();
        }
    }
}
