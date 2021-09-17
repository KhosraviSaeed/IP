package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework2  extends OpenBB{
	
	String imageName1 = "carsl_brighten";
	String imageName2 = "cars_mult";
	
	Image image, originalImage;
	int[][] imagePixels;
	double contrast;
	
	public Homework2(double c, int d){
		
		if(d ==1){
		try {
			contrast = c;
			originalImage = ImageIO.read(new File("cars1.bmp"));
			imagePixels = new int[200][150];
			imagePixels = imageToMatrix((BufferedImage)originalImage);
			for(int i=0; i<200; i++){
				for(int j=0; j<150; j++){
					if(imagePixels[i][j]+c >255)
						imagePixels[i][j] = 255;
					else
					imagePixels[i][j] = (int)(imagePixels[i][j]+c);
				}
			}
			
			image = matrixToImage(imageName1,imagePixels);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				contrast = c;
				originalImage = ImageIO.read(new File("cars1.bmp"));
				imagePixels = new int[200][150];
				imagePixels = imageToMatrix((BufferedImage)originalImage);
				for(int i=0; i<200; i++){
					for(int j=0; j<150; j++){
						if(imagePixels[i][j]*c >255)
							imagePixels[i][j] = 255;
						else
						imagePixels[i][j] = (int)(imagePixels[i][j]*c);
					}
				}
				
				image = matrixToImage(imageName2,imagePixels);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	

public Image getImage(){
	return image;
}
public Image getOriginalImage(){
	return originalImage;
}
	
}