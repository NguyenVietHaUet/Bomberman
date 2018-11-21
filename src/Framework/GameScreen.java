package Framework;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public abstract class GameScreen extends JFrame implements KeyListener{
    public int x,y,width,height;
    public GameThread gameThread;
    final int keyPressed = 0;
    final int keyReleased = 1;

    public GameScreen(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	InitScreen();
	gameThread = new GameThread(this);
	gameThread.setPreferredSize(new Dimension(width, height));
	add(gameThread);
	pack();
    }
    
    public void InitScreen() {
	setSize(width, height);
	setLocation(x, y);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	addKeyListener(this);
    }
    
    public void GameStart() {
	gameThread.startThread();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyAction(e,keyPressed);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyAction(e,keyReleased);
    }
    
    public abstract void gameUpdate (long time);
    public abstract void gamePaint( Graphics2D g2);
    public abstract void keyAction(KeyEvent e, int event);
}
