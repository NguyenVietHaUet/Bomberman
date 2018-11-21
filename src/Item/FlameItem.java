package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlameItem {
	protected int loc_x,loc_y;
	public FlameItem(int x, int y) {
		this.loc_x = x;
		this.loc_y = y;
		
	}
	
	public void draw(Graphics2D g2, FlameItem flameItem) {
		try {
			BufferedImage image;
			image = ImageIO.read(new File("Target/icon/powerup_flames.png"));
			g2.drawImage(image, flameItem.loc_x, flameItem.loc_y, 40, 40, null);
		} catch (IOException e) {}
		
	}
}
