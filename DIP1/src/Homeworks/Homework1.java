package Homeworks;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework1  extends OpenBB{
	
	private Image image,image2;
	
	public Homework1(){
		
		init();
		init2();
		
	}
	
	
private void init() {
		
		try {
			String imageName = "Imcheck";
			int[][] gray = new int[400][400];
			int[][] green = new int[400][400];
			int[][] blue = new int[400][400];
			
			for(int i=0; i<400; i++){
				for(int j=0; j<400; j++){
					int z = (int)(j/50);
					int k = (int)(i/50);
					if(z%2 == 0){
						if(k%2==0)
							gray[i][j] = green[i][j] = blue[i][j] = 0;
						else
							gray[i][j] = green[i][j] = blue[i][j] = 255;
					}
					else{
						if(k%2!=0)
							gray[i][j] = green[i][j] = blue[i][j] = 0;
						else
							gray[i][j] = green[i][j] = blue[i][j] = 255;
						
					}
				}
			}
			
			image = matrixToImage(imageName,gray);
			image = ImageIO.read(new File(imageName+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
private void init2() {
		
		try {
			String imageName = "Imbw";
			int[][] red = new int[400][400];
			int[][] green = new int[400][400];
			int[][] blue = new int[400][400];
			for(int i=0; i<400;i++){
				for(int j=0; j<400; j++){
					if(i>200)
						red[i][j] = green[i][j] = blue[i][j] = 0;
					else
						red[i][j] = green[i][j] = blue[i][j] = 255;
						
				}
			}
			image2 = createImage(imageName,red,green,blue);
			image2 = ImageIO.read(new File(imageName+".bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


public static BufferedImage createImage(String name,int[][] red, int[][] green, int[][] blue){
	
	int w=red.length;
	int h=red[0].length;
	BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
	for (int i = 0; i < w; i++) {
		for (int j = 0; j < h; j++) {
			Color c = new Color(red[i][j], green[i][j], blue[i][j]);
			image.setRGB(i, j, c.getRGB());
		}
	}
	File output=new File(name+".bmp");
	try {
		ImageIO.write(image,"bmp",output);
		}catch (Exception e){
			e.printStackTrace();
			}
	return image;

}

public Image getImage(){
	return image;
}
public Image getImage2(){
	return image2;
}


}
