package Framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadMap {
    public int [][] map = new int[13][33];
    public LoadMap() {
	try {
            File file = new File("Target/Map/map_lever1");
                if(!file.exists())
                    System.out.println("not file");
                    FileReader fr = new FileReader(file);
                    int c;
                    for(int i=0;i<13;i++) {
                        for(int j=0;j<33;j++) {
                            try {
                                this.map[i][j] =  fr.read();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                        }	
                    }			
	} catch (FileNotFoundException e) {}
    }
}
