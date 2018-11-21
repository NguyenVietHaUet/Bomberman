package Object;

import Framework.LoadMap;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bomber {
    
    public int loc_x = 0, loc_y = 0;
    protected int point = 0;
    protected int speed = 3;
    protected int [] animation= {-1,-1,-1,0}; //up-down-left-right
    
    public Bomber(){
        setLocation();
        
    }
    
    public void move(Bomber bomber, KeyEvent e, int[][] map) {
        
		System.out.println(bomber.loc_x +" "+ bomber.loc_y);
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(bomber.loc_y%40>32 || bomber.loc_y%40 > (40-2*speed))
				bomber.loc_y= (bomber.loc_y/40)*40+40;
			else if(bomber.loc_y%40<8 || bomber.loc_y%40 < 2*speed)
				bomber.loc_y= (bomber.loc_y/40)*40;
			bomber.loc_x  -= bomber.speed;	//left
			bomber.animation[0]=-1;
			bomber.animation[1]=-1;
			bomber.animation[2]++;
			bomber.animation[3]=-1;
			if(isMove(bomber, map)==false) 
				bomber.loc_x  += bomber.speed;
		}	
		else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bomber.loc_x  += bomber.speed; // right
			if(bomber.loc_y%40>32 || bomber.loc_y%40 > (40-2*speed))
				bomber.loc_y= (bomber.loc_y/40)*40+40;
			else if(bomber.loc_y%40<8 || bomber.loc_y%40 < 2*speed)
				bomber.loc_y= (bomber.loc_y/40)*40;
			{
				bomber.animation[0]=-1;
				bomber.animation[1]=-1;
				bomber.animation[2]=-1;
				bomber.animation[3]++;
			}
			if(isMove(bomber, map)==false) 
				bomber.loc_x  -= bomber.speed;
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			bomber.loc_y  -= bomber.speed;	//up
			if(bomber.loc_x%40>32 || bomber.loc_x%40 > (40-2*speed))
				bomber.loc_x= (bomber.loc_x/40)*40+40;
			else if(bomber.loc_x%40<8 || bomber.loc_x%40 < 2*speed)
				bomber.loc_x= (bomber.loc_x/40)*40;
			{
				bomber.animation[0]++;
				bomber.animation[1]=-1;
				bomber.animation[2]=-1;
				bomber.animation[3]=-1;
			}
			if(isMove(bomber, map)==false) 
				bomber.loc_y  += bomber.speed;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			bomber.loc_y  += bomber.speed;	//down
			if(bomber.loc_x%40>32 || bomber.loc_x%40 > (40-2*speed))
				bomber.loc_x= (bomber.loc_x/40)*40+40;
			else if(bomber.loc_x%40<8 || bomber.loc_x%40 < 2*speed)
			bomber.loc_x= (bomber.loc_x/40)*40;
			 {
				bomber.animation[0]=-1;
				bomber.animation[1]++;
				bomber.animation[2]=-1;
				bomber.animation[3]=-1;
			}
			 if(isMove(bomber, map)==false)
				bomber.loc_y  -= bomber.speed;
		}
		
		
		
	}
    
    public boolean isMove(Bomber bomber,int[][] map){ // xét bomber có bị chặn hay không
	int x_right =(int) Math.floor( bomber.loc_x/40.0);
	int x_left = (int) Math.ceil( bomber.loc_x/40.0);
	int y_up = (int) Math.floor( bomber.loc_y/40.0);
	int y_down = (int) Math.ceil( bomber.loc_y/40.0);
//	System.out.println( loc_x +" "+ loc_y +" " +x_left+ " " + x_right +"  "+ y_up+ " " +y_down+" "+ (char)map[y_up][x_right] +" "+ (char)map[y_up][x_left] +" "+ (char)map[y_down][x_right] +" "+ (char)map[y_down][x_left]);
	if(map[y_up][x_right] != ' ' && map[y_up][x_right] != 'b' && map[y_up][x_right] != 'f' && map[y_up][x_right] != 's')	return false;
	else if(map[y_up][x_left] != ' '&& map[y_up][x_left] != 'b' && map[y_up][x_left] != 'f' && map[y_up][x_left] != 's')	return false;
	else if(map[y_down][x_left] != ' '&& map[y_down][x_left] != 'b' && map[y_down][x_left] != 'f' && map[y_down][x_left] != 's')	return false;
	else if(map[y_down][x_right] != ' '&& map[y_down][x_right] != 'b' &&map[y_down][x_right] != 'f' &&map[y_down][x_right] != 's')	return false;
	else return true;
    }
    
    
    public void draw(Graphics2D g2,Bomber bomber) {
	BufferedImage image;
	try {
		if(bomber.animation[0]%3==0)
			image = ImageIO.read(new File("Target/icon/player_up.png"));
		else if(bomber.animation[0]%3==1)
			image = ImageIO.read(new File("Target/icon/player_up_1.png"));
		else if(bomber.animation[0]%3==2)
			image = ImageIO.read(new File("Target/icon/player_up_2.png"));
		else if(bomber.animation[1]%3==0)
			image = ImageIO.read(new File("Target/icon/player_down.png"));
		else if(bomber.animation[1]%3==1)
			image = ImageIO.read(new File("Target/icon/player_down_1.png"));
		else if(bomber.animation[1]%3==2)
			image = ImageIO.read(new File("Target/icon/player_down_2.png"));
		else if(bomber.animation[2]%3==0)
			image = ImageIO.read(new File("Target/icon/player_left.png"));
		else if(bomber.animation[2]%3==1)
			image = ImageIO.read(new File("Target/icon/player_left_1.png"));
		else if(bomber.animation[2]%3==2)
			image = ImageIO.read(new File("Target/icon/player_left_2.png"));
		else if(bomber.animation[3]%3==0)
			image = ImageIO.read(new File("Target/icon/player_right.png"));
		else if(bomber.animation[3]%3==1)
			image = ImageIO.read(new File("Target/icon/player_right_1.png"));
		else 
			image = ImageIO.read(new File("Target/icon/player_right_2.png"));
		g2.drawImage(image, bomber.loc_x, bomber.loc_y, 40, 40, null);
	} catch (IOException e) {}
    }
    
    LoadMap loadMap = new LoadMap();
    public void setLocation(){
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 33; j++){
                if(loadMap.map[i][j] == 'p'){
                    loc_x = j*40;
                    loc_y = i*40;
                }
            }
        }
    }

}
