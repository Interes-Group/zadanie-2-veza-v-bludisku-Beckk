package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Maze.MazeClass;
import sk.stuba.fei.uim.oop.UI.MainUI;

import javax.swing.*;

public class Game {
    private int height = 11;
    private int width = 11;

    MazeClass maze;
    JFrame jFrame;
    public void Start()
    {
        maze = new MazeClass(height, width);
        jFrame = new MainUI("MAZE",maze,this);
        jFrame.setVisible(true);
        ((MainUI)jFrame).maze = maze;

        ((MainUI)jFrame).UpateUI();
    }

    public void Restart()
    {
        maze = new MazeClass(height,width);
        ((MainUI)jFrame).maze = maze;
        ((MainUI)jFrame).player = new Player(maze.getCell(0,0),maze.getCell(height-1,width-1),((MainUI)jFrame));
        ((MainUI)jFrame).UpateUI();
    }
}
