package Object;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicLabelUI;

import Framework.LoadMap;

public  class Enemy {
	protected int speed = 2;
	protected boolean Running = true;
	protected int loc_x=40, loc_y=40;
	LoadMap loadMap = new LoadMap();
	
	public ArrayList<Balloom> ballooms = new ArrayList<Balloom>();
	public ArrayList<Oneal> oneals  = new ArrayList<Oneal>();
	
	public Enemy() {
			for(int i=0;i<13;i++) {
				for(int j=0;j<33;j++) {
					if(loadMap.map[i][j] == '1') {
						loc_x = j*40;
						loc_y = i*40;
						this.ballooms.add(new Balloom(loc_x, loc_y, speed));
					}
					else if(loadMap.map[i][j] == '2') {
						loc_x = j*40;
						loc_y = i*40;
						this.oneals.add(new Oneal(loc_x, loc_y, speed));
					}
				}	
			}			
	}
}
