package sk.stuba.fei.uim.oop.UI;

import sk.stuba.fei.uim.oop.Game;
import sk.stuba.fei.uim.oop.Maze.MazeClass;
import sk.stuba.fei.uim.oop.MouseControl.MouseHandler;
import sk.stuba.fei.uim.oop.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame implements KeyListener, MouseListener {
    private JPanel MainPanel;
    private JPanel DrawPanel;
    private JButton Restart;
    private JButton DownButton;
    private JButton LeftButton;
    private JButton RightButton;
    private JButton UpButton;
    private JLabel Score;
    private int points = 0;

    public MazeClass maze;
    public Player player;
    public Game game;
    private MouseHandler mouseHandler = new MouseHandler();
    public MainUI(String title,MazeClass mazeClass,Game game)
    {
        super(title);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.PAGE_AXIS));
        this.setContentPane(MainPanel);
        this.pack();
        this.game = game;
        this.maze = mazeClass;
        this.addKeyListener(this);
        this.addMouseListener(this);
        Player player = new Player(maze.getCell(0,0),maze.getCell(maze.getHeight()-1,maze.getWeight() - 1),this);
        this.player = player;
        Score.setText("Score: " + points);
        UpButton.setFocusable(false);
        DownButton.setFocusable(false);
        LeftButton.setFocusable(false);
        RightButton.setFocusable(false);
        Restart.setFocusable(false);
        DownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MovePlatyerButton(3);
            }
        });
        LeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MovePlatyerButton(1);
            }
        });
        RightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MovePlatyerButton(2);
            }
        });
        UpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MovePlatyerButton(0);
            }
        });
        Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mouseHandler.ClearList(((MazeWallDraw)DrawPanel));
                game.Restart();
            }
        });
    }
    private void MovePlatyerButton(int dir)
    {
        mouseHandler.ClearList(((MazeWallDraw)DrawPanel));
        switch (dir)
        {
            case 0:
                player.MoveUP();
                break;
            case 1:
                player.MoveLeft();
                break;
            case 2:
                player.MoveRight();
                break;
            case 3:
                player.MoveDown();
                break;
        }
    }
    public void UpateUI()
    {

        ((MazeWallDraw)DrawPanel).wallList.InsertArray(maze);
        ((MazeWallDraw)DrawPanel).player = player;
        ((MazeWallDraw)DrawPanel).repaint();
    }

    public void Win()
    {
        points ++;
        Score.setText("Score: " + points);
        game.Restart();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        mouseHandler.ClearList(((MazeWallDraw)DrawPanel));
        player.KeyManage(keyEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        mouseHandler.ClearList(((MazeWallDraw)DrawPanel));
        player.KeyManage(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    private void createUIComponents() {
        DrawPanel = new MazeWallDraw();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseHandler.OnMouseClicked(mouseEvent,player,((MazeWallDraw)DrawPanel),this);

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
