package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework7  extends OpenBB{
	
	private Image cameraMan,cameraManR;
	private int[][] camera,cameraP;
	
	public Homework7(){
		
		try {
			cameraMan = ImageIO.read(new File("cameraman.jpg"));
			camera = new int[256][256];
			cameraP = new int[256][256];
			camera = imageToMatrix((BufferedImage)cameraMan);
			rotate(45);
			cameraManR = matrixToImage("camera_rotated_"+45, cameraP);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void rotate(int theta) {
		
		int width  = camera.length;
        int height = camera[0].length;
        //double radiant = (theta*Math.PI)/180;
        
        double sin = Math.sin(-theta);
        double cos = Math.cos(-theta);
        double x0 =  width/2;     
        double y0 =  height/2;     


        // rotation
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double a = x - x0;
                double b = y - y0;
                
                int xx = (int) (x0+(cos*a+sin*b));
                int yy = (int) (y0+(-sin*a+cos*b));
                
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    cameraP[x][y] = camera[xx][yy];  
                }else
                	cameraP[x][y] = 0;
            }
        }
		
		
	}

	
	public Image getImage(){
		return cameraMan;
	}
	public Image getImageR(){
		return cameraManR;
	}


}
