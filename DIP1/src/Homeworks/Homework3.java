package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework3  extends OpenBB{
	
	Image balloon,image,image2,image3,balloontemp;
	int[][] balloonP,imageP,imageP2;
	String imagePart,imagePart2,balloonPart;
	
	
	public Homework3(){
		try {
			imagePart = "balloon_part";
			imagePart2 = "balloon_part2";
			balloonPart= "balloon_part3";
			balloon = ImageIO.read(new File("balloon.bmp"));
			balloonP = new int[500][360];
			imageP = new int[200][100];
			imageP2 = new int[500][360];
			balloonP = imageToMatrix((BufferedImage)balloon);
			
			for(int i=0; i<500; i++){
				for(int j=0; j<360; j++){
					if(i>=100 && j>=100 && i<300 && j<200){
						imageP[i-100][j-100] = balloonP[i][j];
						balloonP[i][j] = 0;
					}
				}
			}
			image2 = flipVer(imageP);
			image3 = flipHor(imageP);
			image = matrixToImage(imagePart, imageP);
			balloon = matrixToImage(balloonPart,balloonP);
			imageP2 = imageToMatrix((BufferedImage)image2);
			int[][] temp = new int[500][360];
			for(int i=0; i<500;i++){
				for(int j=0; j< 360; j++){
					if(i>=100 && j>=100 && i<300 && j<200){
						balloonP[i][j] = imageP2[i-100][j-100];
					}
				}
			}
			
			balloontemp = matrixToImage("temp",balloonP);
			
			

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
public Image getImage(){
	return image;
}
public Image getImage2(){
	return image2;
}
public Image getImage3(){
	return image3;
}
public Image getBalloon(){
	return balloon;
}
public Image getBalloonTemp(){
	return balloontemp;
}

public Image flipVer(int[][] im){
	int[][] temp = new int[200][100];
	for(int i=0; i<200; i++){
		for(int j =0; j<100; j++){
			temp[i][j] = im[i][99-j];
		}
	}
	return matrixToImage("temp",temp);
}

public Image flipHor(int[][] im){
	int[][] temp = new int[200][100];
	for(int i=0; i<200; i++){
		for(int j =0; j<100; j++){
			temp[i][j] = im[199-i][j];
		}
	}
	return matrixToImage("temp2",temp);
}
	

	

}
