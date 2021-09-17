import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IP5 extends OpenBB {

	Image image,image2,image3,image4;
	int[][] imageMatrix,imageMatrix2,imageMatrix3,imageMatrix4;
	double[][] imageMatrixD,imageMatrix2D,imageMatrix3D,imageMatrix4D;
	double[][] kernel = {{0.1111111111,0.1111111111,0.1111111111},
			     {0.1111111111,0.1111111111,0.1111111111},
			     {0.1111111111,0.1111111111,0.1111111111}};
	public IP5(){
	
		try {
			image = ImageIO.read(new File("house.jpg"));
			imageMatrix = imageToMatrix((BufferedImage)image);
			imageMatrix2D = convolve(imageMatrix,kernel);
			image2 = matrixToImage("blured", doubleToInt(imageMatrix2D));
			//showMatrix(intToDouble(imageMatrix2));
			imageMatrixD = intToDouble(imageMatrix);
			imageMatrix3D = imageMatrix2D;
			for(int i=0; i<imageMatrix.length;i++){
				for(int j=0; j<imageMatrix[0].length; j++){
					imageMatrix3D[i][j] = imageMatrixD[i][j] - imageMatrix2D[i][j];
					if(imageMatrix3D[i][j]<0)imageMatrix3D[i][j]=0;
				}
			}
			//showMatrix(imageMatrix3D);
			
			int k = 1;
			imageMatrix4D = new double[imageMatrix.length][imageMatrix[0].length];
			for(int i=0; i<imageMatrix.length;i++){
				for(int j=0; j<imageMatrix[0].length; j++){
					imageMatrix4D[i][j] = imageMatrixD[i][j] + k*imageMatrix3D[i][j];
					
					if(imageMatrix4D[i][j]>255)imageMatrix4D[i][j]=255;
				}
			}
			imageMatrix3 = doubleToInt(imageMatrix3D);
			imageMatrix4 = doubleToInt(imageMatrix4D);
			image3 = matrixToImage("IP5_1", imageMatrix3);
			image4 = matrixToImage("IP5_2", imageMatrix4);
			
			
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
	public Image getImage4(){
		return image4;
	}
}
