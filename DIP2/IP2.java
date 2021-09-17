import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IP2 extends OpenBB{
	
	Image image,image2,image3;
	int[] histogram,histogram2,histogram3;
	int[][] imageMatrix, imageMatrix2,imageMatrix3;
	int c , d;
	double C;
	//------------e f g h------------------
	Image image4,image5,image6,image7,image8, image9;
	int[] histogram4,histogram5,histogram6,histogram7,histogram8,histogram9;
	int[][] imageMatrix4,imageMatrix5,imageMatrix6,imageMatrix7,imageMatrix8,imageMatrix9;
	double Gamma;
	public IP2(){
		try {
			// ------- 2 a ,b, c, d -------------
			C = 1.6;
			image = ImageIO.read(new File("LenaDark.png"));
			histogram = calHistogram(image);
			imageMatrix = imageToMatrix((BufferedImage)image);
			imageMatrix2 = histogramStreching(histogram,imageMatrix);
			c = getcc();
			d = getdd();
			image2 = matrixToImage("LenaDark_strech", imageMatrix2);
			histogram2 = calHistogram(image2);
			imageMatrix3 = multCToImagePixels(imageMatrix, C);
			image3 = matrixToImage("LenaDark_multC", imageMatrix3);
			histogram3 = calHistogram(image3);
			
			//-------- 2 e f g h -----------------
			C = 50;
			image4 = ImageIO.read(new File("wom.gif"));
			histogram4 = calHistogram(image4);
			imageMatrix4 = imageToMatrix((BufferedImage)image4);
			imageMatrix5 = logNormalization(imageMatrix4,C);
			image5 = matrixToImage("wom_log", imageMatrix5);
			histogram5 = calHistogram(image5);
			C = 1;
			Gamma = 1.35;
			imageMatrix6 = powerLaw(imageMatrix4, C, Gamma);
			image6 = matrixToImage("wom_pow_log", imageMatrix6);
			histogram6 = calHistogram(image6);
			
			image7 = ImageIO.read(new File("trn.gif"));
			histogram7 = calHistogram(image7);
			imageMatrix7 = imageToMatrix((BufferedImage)image7);
			C = 50;
			imageMatrix8 = logNormalization(imageMatrix7,C);
			image8 = matrixToImage("trn_log", imageMatrix8);
			histogram8 = calHistogram(image8);
			
			C = 1;
			Gamma = 1.20;
			imageMatrix9 = powerLaw(imageMatrix7, C, Gamma);
			image9 = matrixToImage("trn_pow_log", imageMatrix9);
			histogram9 = calHistogram(image9);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -----------------------------
	public Image getImage(){
		return image;
	}
	public Image getImage2(){
		return image2;
	}
	public Image getImage3(){
		return image3;
	}
	public int[] getImageHistogram(){
		return histogram;
	}
	public int[] getImageHistogram2(){
		return histogram2;
	}
	public int[] getImageHistogram3(){
		return histogram3;
	}
	public int getc(){
		return c;
	}
	
	public int getd(){
		return d;
	}
	public double getC(){
		return C;
	}
	//------------------------
	
	public Image getImage4(){
		return image4;
	}
	public int[] getImageHistogram4(){
		return histogram4;
	}
	
	public Image getImage5(){
		return image5;
	}
	public int[] getImageHistogram5(){
		return histogram5;
	}
	
	public Image getImage6(){
		return image6;
	}
	public int[] getImageHistogram6(){
		return histogram6;
	}
	
	public double getGamma(){
		return Gamma;
	}
	
	public Image getImage7(){
		return image7;
	}
	public int[] getImageHistogram7(){
		return histogram7;
	}
	
	public Image getImage8(){
		return image8;
	}
	public int[] getImageHistogram8(){
		return histogram8;
	}
	
	public Image getImage9(){
		return image9;
	}
	public int[] getImageHistogram9(){
		return histogram9;
	}
	
	
	

	

}
