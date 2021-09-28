import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
	
	//Variables
	private static final int WIDTH = 15, HEIGHT = 90;
    private Pong game;
    private int up, down;
    private int x;
    private int y, ya;

    //Constructor
    public Paddle(Pong game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }

    //Update
    public void update() {
    	//Check collision for moving up & moving down
        if (y > 0 && y < game.getHeight() - HEIGHT - 29)
            y += ya;
        else if (y == 0)
            y++;
        else if (y == game.getHeight() - HEIGHT - 29)
            y--;
    }

    //Check key pressed move paddle up or down
    public void pressed(int keyCode) {
        if (keyCode == up)
            ya = -1;
        else if (keyCode == down)
            ya = 1;
    }

    //Check key released stop moving paddle
    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
    }

    //Return paddle boundaries
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    //Display paddles to screen
    public void paint(Graphics g) {
    	g.setColor(Color.white);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
