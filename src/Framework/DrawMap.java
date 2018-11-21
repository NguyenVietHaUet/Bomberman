package Framework;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class DrawMap extends JPanel{
    
    public int [][] map = new int[13][33];
    
    public void drawMap(Graphics2D g2){
        BufferedImage image;
        DrawImage drawImage = new DrawImage();
        
        try {
            File file = new File("Target/Map/map_lever1");
            if(!file.exists())
                System.out.println("not file");
            FileReader fr = new FileReader(file);
            
            for(int i = 0; i < 13; i++){
                for(int j = 0; j < 33; j++){
                    try {
			map[i][j] =  fr.read();
			if(map[i][j] == 'p' || map[i][j] == '1' || map[i][j] == '2' || map[i][j] == 'b' ) 
                            map[i][j]=' ';
			image = drawImage.setImage((char)map[i][j]);
			drawImage.drawImage(image, g2, j*40, i*40);
                    } catch (IOException e) {}
                }
            }
        } catch (FileNotFoundException ex) {}
    }
    
}
