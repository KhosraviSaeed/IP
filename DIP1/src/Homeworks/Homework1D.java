package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import javax.imageio.ImageIO;

public class Homework1D  extends OpenBB{
	
	Homework1 hw;
	Homework1C hw1C;
	Image image6;
	int[][] image6Pixels,imagePixels, image2Pixels;
	
	public Homework1D(){
		hw = new Homework1();
		hw1C = new Homework1C();
		image6Pixels = new int[400][400];
		imagePixels = new int[400][400];
		image2Pixels = new int[400][400];
		imagePixels = imageToMatrix((BufferedImage)hw.getImage());
		image2Pixels = imageToMatrix((BufferedImage)hw1C.getImage6());
		for(int i =0; i<400; i++){
			for(int j=0; j<400; j++){
				if(image2Pixels[i][j]-imagePixels[i][j]<0){
					image6Pixels[i][j] = 0;
				}else
					image6Pixels[i][j] = image2Pixels[i][j]-imagePixels[i][j];
			}
		}
		
		image6 = matrixToImage("Pl-out3", image6Pixels);
		
	}
	

public Image getImage6(){
	return image6;
}
	

}
