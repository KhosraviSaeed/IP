package Homeworks;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework1C  extends OpenBB{
	
	
	Image image6,image5, originalImage;
	int[][] image5Pixels,image6Pixels;
	String imageName;
	
	public Homework1C(){
		
		init4();
		
	}
	
	private void init4() {
		try {
			imageName = "P1_out2";
			originalImage = ImageIO.read(new File("Imbw.bmp"));
			image5 = resizeImage((BufferedImage)originalImage, 100, 100);
			image5Pixels = new int[100][100];
			image6Pixels = new int[400][400];
			image5Pixels = imageToMatrix((BufferedImage)image5);
			for(int i=0; i<400; i++){
				for(int j=0; j<400; j++){
					image6Pixels[i][j] = image5Pixels[i%100][j%100];
				}
			}
			
			image6 = matrixToImage(imageName, image6Pixels);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BufferedImage resizeImage(BufferedImage originalImage,int w, int h){
		BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, w, h, null);
		g.dispose();

		return resizedImage;
	    }
	
	public Image getImage5(){
		return image5;
	}
	public Image getImage6(){
		return image6;
	}
	
	
	
}
