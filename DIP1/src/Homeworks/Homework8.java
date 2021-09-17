package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework8 extends OpenBB{
	
	private Image cameraMan,cameraManS;
	private int[][] camera;
	
	public Homework8(){
		
		try {
			cameraMan = ImageIO.read(new File("cameraman.jpg"));
			camera = new int[256][256];
			camera = imageToMatrix((BufferedImage)cameraMan);
			cameraManS = shear(0.4,0.2,camera);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	private Image shear(double xShear, double yShear, int[][] cam) {
		
		int width = cam.length;
		int height = cam[0].length;
		int[][] temp = new int[width][height];
		double x0 =  width/2;     
        double y0 =  height/2; 
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double a = x - x0;
                double b = y - y0;
                
                int xx = (int) (a+b*xShear+x0);
                int yy = (int) (a*yShear+b+y0);
                
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    temp[x][y] = cam[xx][yy];  
                }else
                	temp[x][y] = 0;
            }
        }
		
        
		Image img = matrixToImage("cameraman_shear.bmp",temp);
		
		
		
		return img;
	}


	
	public Image getImage(){
		return cameraMan;
	}
	
	public Image getImageS(){
		return cameraManS;
	}

}
