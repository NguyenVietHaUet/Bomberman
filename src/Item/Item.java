package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Framework.LoadMap;
import Object.Balloom;
import Object.Oneal;

public  class Item {
	protected int loc_x;
	protected int loc_y;
	protected boolean Show;
	public ArrayList<BombItem> bombItems = new ArrayList<BombItem>();
	public ArrayList<FlameItem> flameItems = new ArrayList<FlameItem>();
	public ArrayList<SpeedItem> speedItems = new ArrayList<SpeedItem>();
	
	
	public Item() {
		LoadMap loadMap = new LoadMap();
		for(int i=0;i<13;i++) {
			for(int j=0;j<33;j++) {
				if(loadMap.map[i][j] == 'b') {
					loc_x = j*40;
					loc_y = i*40;
					this.bombItems.add(new BombItem(loc_x, loc_y));
				}
				else if(loadMap.map[i][j] == 'f') {
					loc_x = j*40;
					loc_y = i*40;
					this.flameItems.add(new FlameItem(loc_x, loc_y));
				}
				else if(loadMap.map[i][j] == 's') {
					loc_x = j*40;
					loc_y = i*40;
					this.speedItems.add(new SpeedItem(loc_x, loc_y));
				}
			}	
		}			
}
	
	
	
}
