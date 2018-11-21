package Framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GameThread extends  JPanel implements Runnable{
    
    protected int width, height;
    int x = 0;
    Thread thread;
    GameScreen gameScreen;
    BufferedImage bufferedImage;
    
    
    public GameThread(GameScreen gameScreen) {
	this.width = gameScreen.width;
	this.height = gameScreen.height;
	this.gameScreen = gameScreen;
	this.thread = new Thread(this);
	}
    
    public void paint(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(0, 0, width, height);
	Graphics2D g2 = (Graphics2D)g;
        if(bufferedImage!=null){
            g2.drawImage(bufferedImage, 0, 0, this);
        }
    }
    
    public void startThread() {
	thread.start();
    }
    @Override
    public void run() {
        while(true) {
			
//			gameScreen.gameUpdate(System.currentTimeMillis());
            try {
		Thread.sleep(40);
            } catch (InterruptedException e) {}
            try{
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                if(bufferedImage == null) return;
                Graphics2D g2 = (Graphics2D) bufferedImage.getGraphics();
                
                if(g2!=null){
                    gameScreen.gamePaint(g2);
                }
                    
            }catch(Exception myException){
                myException.printStackTrace();
            }
            repaint();
		}
    }
    
    
}
