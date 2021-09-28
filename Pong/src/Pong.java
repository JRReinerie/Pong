import java.awt.Color;

import javax.swing.JFrame;

public class Pong extends JFrame{
	
	//Variables
	private final static int WIDTH = 700, HEIGHT = 450;
    private PongPanel panel;

    //Constructor
    public Pong() {
        setSize(WIDTH, HEIGHT);
        setTitle("Java Pong v1.1. project made by: Jason Reinerie");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new PongPanel(this);
        add(panel);
    }

    //Return pongPanel
    public PongPanel getPanel() {
        return panel;
    }

    //Make a new game
    public static void main(String[] args) {
        new Pong();
    }
}
