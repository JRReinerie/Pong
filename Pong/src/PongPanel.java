import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import javax.swing.JPanel;

public class PongPanel extends JPanel implements ActionListener, KeyListener{

	//Variables
	private static final long serialVersionUID = 1L;
	private Pong game;
    private Ball ball;
    private Paddle player1, player2;
    private int score1, score2;
	
    //Constructor
    public PongPanel(Pong game) {
    	//Add everything to game
    	setBackground(Color.black);
        this.game = game;
        ball = new Ball(game);
        player1 = new Paddle(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
        player2 = new Paddle(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    
    //Return Player1 or Player2
    public Paddle getPlayer(int playerNo) {
        if (playerNo == 1)
            return player1;
        else
            return player2;
    }
    
    //Increase score of Player1 or Player2
    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }

    //Return the score of Player1 or Player2
    public int getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }
    
    //Update everything in game
    private void update() {
        ball.update();
        player1.update();
        player2.update();
    }

    //After action performed
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    
    //Add Player key pressed
    public void keyPressed(KeyEvent e) {
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }

    //Add Player key released
    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
    }
    
    //Method need
    public void keyTyped(KeyEvent e) {
        ;
    }
    
    //Display everything on screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(game.getWidth() / 2, 0, 4, game.getHeight());
        Font stringFont = new Font( "SansSerif", Font.PLAIN, 40 );
        g.setFont(stringFont);
        g.drawString(game.getPanel().getScore(1) + "      " + game.getPanel().getScore(2), game.getWidth() / 2 - 57, 40);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
    }

}
