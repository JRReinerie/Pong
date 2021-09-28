import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Ball {
	
	//Ball variables
	private static final int WIDTH = 20, HEIGHT = 20;
    private Pong game;
    private int x, y;
    private int xa = 2, ya = 2;

    //Constructor
    public Ball(Pong game) {
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }
    
    //Update frame
    public void update() {
    	
    	//Ball moving
        x += xa;
        y += ya;
        
        //Ball collision for score system
        if (x < 0) {
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (x > game.getWidth() - WIDTH - 7) {
            game.getPanel().increaseScore(2);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
        if (game.getPanel().getScore(1) == 10) {
            JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        	System.exit(0);
        }else if (game.getPanel().getScore(2) == 10) {
            JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        	System.exit(0);
        }
        checkCollision();
    }

    //Collision check ball hitting paddle
    public void checkCollision() {
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
    }

    //Return ball boundaries
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    //Display ball to screen
    public void paint(Graphics g) {
    	g.setColor(Color.white);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
