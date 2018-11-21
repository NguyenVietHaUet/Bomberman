package Object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Framework.LoadMap;

public class Balloom{
	protected int loc_x, loc_y,speed;
	protected boolean isRun = true;
	protected boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
	protected int chosee = 1;
	protected int[] animation = {-1,-1,-1,-1}; // left right up down
	public Balloom(int x, int y, int speed) {
		this.loc_x=x;
		this.loc_y =y;
		this.speed = speed;
	}
	
	public void move(int [][] map) {
		if(LEFT == false && RIGHT == false && UP == false && DOWN == false ) {
			Random random = new Random();
//			random.
			chosee = random.nextInt()%4;
			if(chosee ==0)	LEFT = true;
			else if(chosee == 1) RIGHT = true;
			else if(chosee == 2) UP = true;
			else	DOWN = true;
		}
			
			if(LEFT) {
				this.loc_x-= speed;// left
				animation[0]++;
				animation[1]=-1;
				animation[2]=-1;
				animation[3]=-1;
				if(isMove(this, map)==false) {
					this.loc_x+= speed;
					LEFT=false;
				}
					
			}
			else if(RIGHT) {
				this.loc_x+= speed; //right
				animation[0]=-1;
				animation[1]++;
				animation[2]=-1;
				animation[3]=-1;
				if(isMove(this, map)==false) {
					this.loc_x-= speed;
					RIGHT=false;
				}
			}
				
			else if(UP) {
				this.loc_y -= speed;// up
				animation[0]=-1;
				animation[1]=-1;
				animation[2]++;
				animation[3]=-1;
				if(isMove(this, map)==false) {
					this.loc_y+= speed;
					UP=false;
				}
			}
			else if(DOWN)	{
				this.loc_y += speed;// down
				animation[0]=-1;
				animation[1]=-1;
				animation[2]=-1;
				animation[3]++;
				if(isMove(this, map)==false) {
					this.loc_y-= speed;
					DOWN=false;
				}
			}
	}
	
	public boolean isMove(Balloom balloom,int[][] map){
		int x_right =(int) Math.floor( balloom.loc_x/40.0);
		int x_left = (int) Math.ceil( balloom.loc_x/40.0);
		int y_up = (int) Math.floor( balloom.loc_y/40.0);
		int y_down = (int) Math.ceil( balloom.loc_y/40.0);
		if(map[y_up][x_right] != ' ' && map[y_up][x_right] != 'b' && map[y_up][x_right] != 'f' && map[y_up][x_right] != 's')	return false;
		else if(map[y_up][x_left] != ' '&& map[y_up][x_left] != 'b' && map[y_up][x_left] != 'f' && map[y_up][x_left] != 's')	return false;
		else if(map[y_down][x_left] != ' '&& map[y_down][x_left] != 'b' && map[y_down][x_left] != 'f' && map[y_down][x_left] != 's')	return false;
		else if(map[y_down][x_right] != ' '&& map[y_down][x_right] != 'b' &&map[y_down][x_right] != 'f' &&map[y_down][x_right] != 's')	return false;
		else return true;
	}

	public void draw(Graphics2D g2,Balloom balloom, int [][] map) {
		BufferedImage image;
		try {
			move(map);
			if(balloom.animation[0]%3==0)
				image = ImageIO.read(new File("Target/icon/balloom_left1.png"));
			else if(balloom.animation[0]%3==1)
				image = ImageIO.read(new File("Target/icon/balloom_left2.png"));
			else if(balloom.animation[0]%3==2)
				image = ImageIO.read(new File("Target/icon/balloom_left3.png"));
			else if(balloom.animation[1]%3==1)
				image = ImageIO.read(new File("Target/icon/balloom_right2.png"));
			else if(balloom.animation[1]%3==2)
				image = ImageIO.read(new File("Target/icon/balloom_right3.png"));
			else if(balloom.animation[1]%3==0)
				image = ImageIO.read(new File("Target/icon/balloom_right1.png"));
			else if(balloom.animation[2]%3==0)
				image = ImageIO.read(new File("Target/icon/balloom_left1.png"));
			else if(balloom.animation[2]%3==1)
				image = ImageIO.read(new File("Target/icon/balloom_left2.png"));
			else if(balloom.animation[2]%3==2)
				image = ImageIO.read(new File("Target/icon/balloom_left3.png"));
			else if(balloom.animation[3]%3==1)
				image = ImageIO.read(new File("Target/icon/balloom_right2.png"));
			else if(balloom.animation[3]%3==2)
				image = ImageIO.read(new File("Target/icon/balloom_right3.png"));
			else
				image = ImageIO.read(new File("Target/icon/balloom_right1.png"));
//			System.out.println(animation[0]);
			g2.drawImage(image, balloom.loc_x, balloom.loc_y, 40, 40, null);
		} catch (IOException e) {}
	}
}
