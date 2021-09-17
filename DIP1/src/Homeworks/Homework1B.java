package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework1B  extends OpenBB{
	
	private Image image,image2,image3,image4;
	private int[][] imagePixels,image2Pixels,image3Pixels,image4Pixels;
	
	public Homework1B(){
		init3();
		image3 = matrixToImage("P1_out1", image3Pixels);
		image4 = matrixToImage("P1_out1_b", image4Pixels);
	}
	
	private void init3() {
		try {
			image = ImageIO.read(new File("Imcheck.bmp"));
			image2 = ImageIO.read(new File("Imbw.bmp"));
			imagePixels = new int[400][400];
			image2Pixels = new int[400][400];
			image3Pixels = new int[400][400];
			image4Pixels = new int[400][400];
			imagePixels = imageToMatrix((BufferedImage)image);
			image2Pixels = imageToMatrix((BufferedImage)image2);
			image4Pixels = imagePixels;
			for(int i=0; i<400; i++){
				for(int j=0; j<400; j++){
					image2Pixels[i][j]= (int)((image2Pixels[i][j] *5)/10);
					if(image2Pixels[i][j]+imagePixels[i][j]> 255)
						image3Pixels[i][j] = 255;
					else
					image3Pixels[i][j]= image2Pixels[i][j]+imagePixels[i][j];
					
					
					if(image4Pixels[i][j] == 255){
						image4Pixels[i][j] = 0;
					}else{
						image4Pixels[i][j] = 255;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Image getImage3(){
		return image3;
	}
	public Image getImage4(){
		return image4;
	}
	
	
	

}
