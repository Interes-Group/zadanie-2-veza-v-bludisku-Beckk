package sk.stuba.fei.uim.oop.MouseControl;

import sk.stuba.fei.uim.oop.Maze.CellClass;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.UI.MainUI;
import sk.stuba.fei.uim.oop.UI.MazeWallDraw;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseHandler {

    private Player player;
    private ArrayList<possiblePosition> possiblePositions = new ArrayList<>();
    public void OnMouseClicked(MouseEvent mouseEvent, Player player, MazeWallDraw mazeWallDraw, MainUI mainUI)
    {
        if(possiblePositions.size() > 0)
        {
            possiblePosition position = GetClikedPosition(mouseEvent);
            if(position != null)
            {
                player.SetNewPosition(position.getCell());
            }
            possiblePositions.clear();
            mazeWallDraw.possiblePositions.clear();
            mainUI.UpateUI();
        }
        else
        {
            if((mouseEvent.getX() > player.getCurrent().getJ() * 40 + 25 ) &&
                    (mouseEvent.getX() < (player.getCurrent().getJ() ) * 40 + 65) &&
                    (mouseEvent.getY() > player.getCurrent().getI() * 40 + 55) &&
                    (mouseEvent.getY() < (player.getCurrent().getI() ) * 40 + 85))
            {
                this.player = player;
                GeneratePositions();
                mazeWallDraw.possiblePositions = possiblePositions;
                mainUI.UpateUI();
            }
        }
    }
    public void ClearList(MazeWallDraw mazeWallDraw)
    {
        possiblePositions.clear();
        mazeWallDraw.possiblePositions.clear();

    }
    private possiblePosition GetClikedPosition(MouseEvent mouseEvent)
    {
        for(possiblePosition position:possiblePositions)
        {
            if((mouseEvent.getX() > position.getX() +25) &&
                    (mouseEvent.getX() < (position.getX() ) + 65) &&
                    (mouseEvent.getY() > position.getY()  + 55) &&
                    (mouseEvent.getY() < (position.getY() ) + 85))
            {
                return position;
            }
        }
        return null;
    }
    private void GeneratePositions()
    {
        GetUpPositions(player.getCurrent());
        GetLeftPositions(player.getCurrent());
        GetRightPositions(player.getCurrent());
        GetDownPositions(player.getCurrent());
    }

    public void GetUpPositions(CellClass cell)
    {
        if(cell.getWall()[0] == false)
        {
            possiblePositions.add(new possiblePosition(cell.getUpCell()));
            GetUpPositions(cell.getUpCell());
        }
    }
    public void GetLeftPositions(CellClass cell)
    {
        if(cell.getWall()[1] == false)
        {
            possiblePositions.add(new possiblePosition(cell.getLeftCell()));
            GetLeftPositions(cell.getLeftCell());
        }
    }
    public void GetRightPositions(CellClass cell)
    {
        if(cell.getWall()[2] == false)
        {
            possiblePositions.add(new possiblePosition(cell.getRightCell()));
            GetRightPositions(cell.getRightCell());
        }
    }
    public void GetDownPositions(CellClass cell)
    {
        if(cell.getWall()[3] == false)
        {
            possiblePositions.add(new possiblePosition(cell.getDownCell()));
            GetDownPositions(cell.getDownCell());
        }
    }
}
