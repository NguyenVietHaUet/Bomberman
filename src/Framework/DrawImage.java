package Framework;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawImage {
    
    protected BufferedImage image = null;
    public BufferedImage setImage(char c){
        try{
            switch(c){
                case '#':
                    image = ImageIO.read(new File("Target/icon/wall.png"));
                    break;
                case '*':
                    image = ImageIO.read(new File("Target/icon/brick.png"));
                    break;
                case 'x':
                    image = ImageIO.read(new File("Target/icon/portal.png"));
                    break;
                case 'p':
                    image = ImageIO.read(new File("Target/icon/player_right_1.png"));
                    break;
                case '1':
                    image = ImageIO.read(new File("Target/icon/balloom_left1.png"));
                    break;
                case '2':
                    image = ImageIO.read(new File("Target/icon/oneal_left1.png"));
                    break;
                case 'b':
                    image = ImageIO.read(new File("Target/icon/powerup_bombs.png"));
                    break;
                case 'f':
                    image = ImageIO.read(new File("Target/icon/powerup_flames.png"));
                    break;
                case 's':
                    image = ImageIO.read(new File("Target/icon/powerup_speed.png"));
                    break;
                default:
                    image = ImageIO.read(new File("Target/icon/grass.png"));
            }
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        return image;
    }

    void drawImage(BufferedImage image, Graphics2D g2, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
