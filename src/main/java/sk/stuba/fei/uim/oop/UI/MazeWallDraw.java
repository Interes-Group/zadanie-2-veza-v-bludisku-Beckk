package sk.stuba.fei.uim.oop.UI;

import sk.stuba.fei.uim.oop.MouseControl.possiblePosition;
import sk.stuba.fei.uim.oop.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MazeWallDraw extends JPanel  {
    private int wallOffset = 20;
    private int playerOffset = 10;
    private int w = 40;
    public WallList wallList = new WallList();
    public Player player;
    public ArrayList<possiblePosition> possiblePositions = new ArrayList<>();
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        for(Wall wall : wallList.wallArrayList)
        {
            g2.drawLine(wall.getxStart()+wallOffset,wall.getyStart()+wallOffset,wall.getxEnd()+wallOffset,wall.getyEnd()+wallOffset);
        }

        g2.fillRect(player.getCurrent().getJ() * w + wallOffset + playerOffset,player.getCurrent().getI() * w + wallOffset + playerOffset, 20, 20);
        g2.setColor(Color.GREEN);
        g2.fillRect(player.getEnd().getJ() * w + wallOffset +5,player.getEnd().getI() * w + wallOffset + 5, 35, 35);
        g2.setColor(Color.CYAN);
        if(!possiblePositions.isEmpty())
        {
            for(possiblePosition position:possiblePositions)
            {
                g2.fillRect(position.getX() + wallOffset + 5,position.getY() + wallOffset + 5,35,35);
            }
        }
    }
}
