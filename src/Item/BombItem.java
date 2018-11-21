package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Framework.LoadMap;

public class BombItem {
	protected int loc_x,loc_y;
	public BombItem(int x, int y) {
		this.loc_x = x;
		this.loc_y = y;
		
	}
	
	public void draw(Graphics2D g2, BombItem bombItem) {
		try {
			BufferedImage image;
			image = ImageIO.read(new File("Target/icon/powerup_bombs.png"));
			g2.drawImage(image, bombItem.loc_x, bombItem.loc_y, 40, 40, null);
		} catch (IOException e) {}
		
	}
	
}
