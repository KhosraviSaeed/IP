import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IP3 extends OpenBB{
	
	Image image, image2,image3, image4;
	int[][] imageMatrix = {
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0},
	{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0}};
	int[] histogram, histogram2,histogram3, histogram4;
	
	double[][] table;
	int[][] imageMatrix2,imageMatrix3,imageMatrix4;
	
	public IP3(){
		
		for(int i=0; i<imageMatrix.length; i++){
			for(int j=0; j<imageMatrix[0].length; j++){
				imageMatrix[i][j] = (int)((imageMatrix[i][j]*255)/7);
			}
		}
		image = matrixToImage("hw3", imageMatrix);
		histogram = calHistogram(image);
		table = equalize(imageMatrix,8);
		image2 = Equalize((BufferedImage)image);
		histogram2 = calHistogram(image2);
		
		try {
			image3 = ImageIO.read(new File("LenaDark.png"));
			histogram3 = calHistogram(image3);
			image4 = Equalize((BufferedImage)image3);
			histogram4 = calHistogram(image4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public Image getImage(){
		return image;
	}
	
	public int[] getImageHistogram(){
		return histogram;
	}
	
	public Image getImage2(){
		return image2;
	}
	
	public int[] getImageHistogram2(){
		return histogram2;
	}
	
	public Image getImage3(){
		return image3;
	}
	
	public int[] getImageHistogram3(){
		return histogram3;
	}
	public Image getImage4(){
		return image4;
	}
	
	public int[] getImageHistogram4(){
		return histogram4;
	}
	
	
	
	public Object[][] getTable(){
		return doubleToObject(table);
	}
}
