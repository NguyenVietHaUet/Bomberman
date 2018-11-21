package Bom;

import Framework.DrawMap;
import Framework.GameScreen;
import Item.Item;
import Object.Bomber;
import Object.Enemy;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MainBom extends GameScreen{
    
    final int keyPressed = 0 ,keyReleased = 1;
    Bomber bomber = new Bomber();
    DrawMap drawMap = new DrawMap();
    Enemy enemy = new Enemy();
    Item item = new Item();
    public MainBom() {
	super(100, 100, 31*40, 13*40);
	GameStart();
    }
    public static void main(String[] args) {
        new MainBom();
    }

    @Override
    public void gameUpdate(long time) {
        
    }

    @Override
    public void gamePaint(Graphics2D g2) {
        drawMap.drawMap(g2);
//	System.out.println("*");
	bomber.draw(g2, bomber);
        for(int i=0;i<enemy.ballooms.size();i++) {
		enemy.ballooms.get(i).draw(g2,enemy.ballooms.get(i),drawMap.map);
	}
	for(int i=0;i<enemy.oneals.size();i++) {
		enemy.oneals.get(i).draw(g2, enemy.oneals.get(i),drawMap.map);
	}
	for(int i=0;i<item.bombItems.size();i++) {
		item.bombItems.get(i).draw(g2, item.bombItems.get(i));
	}
	for(int i=0;i<item.flameItems.size();i++) {
		item.flameItems.get(i).draw(g2, item.flameItems.get(i));
	}
	for(int i=0;i<item.speedItems.size();i++) {
		item.speedItems.get(i).draw(g2, item.speedItems.get(i));
	}
    }

    @Override
    public void keyAction(KeyEvent e, int event) {
        if(event == keyPressed)
            bomber.move(bomber, e,drawMap.map);
    }
}
