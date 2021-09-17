package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework2B  extends OpenBB{
	
	Image car1,car2,car3;
	int[][] car1P,car2P,car3P;
	Image image;
	int[][] imageP;
	String imageN;
	
	public Homework2B(){
		try {
			car1 = ImageIO.read(new File("cars1.bmp"));
			car2 = ImageIO.read(new File("cars2.bmp"));
			car3 = ImageIO.read(new File("cars3.bmp"));
			imageN = "cars_blending";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			car1P = new int[200][150];
			car2P = new int[200][150];
			car3P = new int[200][150];
			imageP = new int[200][150];
			car1P = imageToMatrix((BufferedImage)car1);
			car2P = imageToMatrix((BufferedImage)car2);
			car3P = imageToMatrix((BufferedImage)car3);
			int x , y, z;
			for(int i=0; i<200; i++){
				for(int j=0; j<150; j++){
					x = (int)((car1P[i][j]*3)/10);
					y = (int)((car2P[i][j]*3)/10);
					z = (int)((car3P[i][j]*3)/10);
					if(x + y + z >255){
						imageP[i][j] = 255;
					}else
						imageP[i][j] = x + y + z;
				}
			}
			
			image = matrixToImage(imageN, imageP);
			
			
				
	}
	
	


	
public Image getImage(){
	return image;
}

public Image getcarImage(){
	return car1;
}
public Image getcar2Image(){
	return car2;
}
public Image getcar3Image(){
	return car3;
}

}
