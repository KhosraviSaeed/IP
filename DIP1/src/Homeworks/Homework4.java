package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import javax.imageio.ImageIO;

public class Homework4  extends OpenBB{
	
	private Image img;
	
	public Homework4(){
		
		int[][] grayScale = new int[256][256];
		for(int dx = 0; dx<256; dx+=10){
			for(int i=dx; i<256 - dx; i++){
				for(int j=dx; j<256 - dx; j++){
				
					grayScale[i][j] = dx;
				
				}
			}
		}
		img = matrixToImage("P4_out1",grayScale);
		
	}
	
	
	
	
	public Image getImage() {
		return img;
	}
	
	

}
