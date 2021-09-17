import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IP4 extends OpenBB{
	
	Image image,image2,image3,image4,image5;
	int[] histogram,histogram2,histogram3,histogram4,histogram5;
	int[][] imageMatrix3, imageMatrix4,imageMatrix5;
	public IP4(){
		
		try {
			image = ImageIO.read(new File("crowd.jpg"));
			histogram = calHistogram(image);
			image2 = Equalize((BufferedImage)image);
			histogram2 = calHistogram(image2);
			saveFile("crowd_equal", (BufferedImage)image2);
			
			image3 = ImageIO.read(new File("pigeon.jpg"));
			image4 = ImageIO.read(new File("soldier.jpg"));
			imageMatrix3 = imageToMatrix((BufferedImage)image3);
			imageMatrix4 = imageToMatrix((BufferedImage)image4);
			histogram3 = calHistogram(image3);
			histogram4 = calHistogram(image4);
			imageMatrix5 = HistogramMatching(imageMatrix3, imageMatrix4);
			image5 = matrixToImage("matching", imageMatrix5);
			histogram5 = calHistogram(image5);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public Image getImage(){
		return image;
	}
	public int[] getHistogram(){
		return histogram;
	}
	public Image getImage2(){
		return image2;
	}
	public int[] getHistogram2(){
		return histogram2;
	}
	public Image getImage3(){
		return image3;
	}
	public int[] getHistogram3(){
		return histogram3;
	}
	public Image getImage4(){
		return image4;
	}
	public int[] getHistogram4(){
		return histogram4;
	}
	
	public Image getImage5(){
		return image5;
	}
	public int[] getHistogram5(){
		return histogram5;
	}
	
	

}
