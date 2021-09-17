import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IP6 extends OpenBB{
	
	Image image,image2,image3,image4,image5, image6,image7,image8,image9,image10,
	image11,image12,image13;
	int[][] imageMatrix,imageMatrix2,imageMatrix3,imageMatrix4;
	double[][] imageMatrixD,imageMatrix2D,imageMatrix3D,
	imageMatrix4D,imageMatrix5D,imageMatrix6D,imageMatrix7D,imageMatrix8D,
	imageMatrix9D,imageMatrix10D,imageMatrix11D,imageMatrix12D,imageMatrix13D;
	double[][] a =  {{0.1111111111,0.1111111111,0.1111111111},
					{0.1111111111,0.1111111111,0.1111111111},
					{0.1111111111,0.1111111111,0.1111111111}};
	double[][] b = {{0.05555555556,0.05555555556,0.05555555556},
					{0.05555555556,0.05555555556,0.05555555556},
					{0.05555555556,0.05555555556,0.05555555556}};
	double[][] c ={{-1,-1,-1},
				   {-1, 9,-1},
				   {-1,-1,-1}};
	double[][] d = {{0,-1, 0},
					{-1,5,-1},
					{0,-1, 0}};
	double[][] e = {{-1,0,1},
					{-1,0,1},
					{-1,0,1}};
	double[][] f = {{-1,-1,-1},
					{0,0,0},
					{1,1,1}};
	double[][] g = {{-1,-1,-1},
					{ 0, 1, 0},
					{ 1, 1, 1}};
	double[][] h = {{0.08333333333,0.08333333333,0.08333333333},
					{0.08333333333,0.3333333333 ,0.08333333333},
					{0.08333333333,0.08333333333,0.08333333333}};
	double[][] i = {{-1, 0, 0},
					{ 0, 0, 0},
					{ 0, 0, 1}};
	double[][] j = {{ 0, 0, -1},
					{ 0, 0, 0},
					{ 1, 0, 0}};
	double[][] k = {{ 0, 1, 0},
					{ 0, 0, 0},
					{ 0, -1, 0}};
	double[][] l = {{ 0, 0, 0},
					{-1, 0, 1},
					{ 0, 0, 0}};
	
	public IP6(){
		
		try {
			image = ImageIO.read(new File("house.jpg"));
			imageMatrix = imageToMatrix((BufferedImage)image);
			imageMatrix2D = convolve(imageMatrix,a);
			image2 = matrixToImage("a", doubleToInt(imageMatrix2D));
			imageMatrix3D = convolve(imageMatrix,b);
			image3 = matrixToImage("b", doubleToInt(imageMatrix3D));
			imageMatrix4D = convolve(imageMatrix,c);
			image4 = matrixToImage("c", doubleToInt(imageMatrix4D));
			imageMatrix5D = convolve(imageMatrix,d);
			image5 = matrixToImage("d", doubleToInt(imageMatrix5D));
			imageMatrix6D = convolve(imageMatrix,e);
			image6 = matrixToImage("e", doubleToInt(imageMatrix6D));
			imageMatrix7D = convolve(imageMatrix,f);
			image7 = matrixToImage("f", doubleToInt(imageMatrix7D));
			imageMatrix8D = convolve(imageMatrix,g);
			image8 = matrixToImage("g", doubleToInt(imageMatrix8D));
			imageMatrix9D = convolve(imageMatrix,h);
			image9 = matrixToImage("h", doubleToInt(imageMatrix9D));
			imageMatrix10D = convolve(imageMatrix,i);
			image10 = matrixToImage("i", doubleToInt(imageMatrix10D));
			imageMatrix11D = convolve(imageMatrix,j);
			image11 = matrixToImage("j", doubleToInt(imageMatrix11D));
			imageMatrix12D = convolve(imageMatrix,k);
			image12 = matrixToImage("k", doubleToInt(imageMatrix12D));
			imageMatrix13D = convolve(imageMatrix,l);
			image13 = matrixToImage("l", doubleToInt(imageMatrix13D));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	
	public Image getImage2() {
		// TODO Auto-generated method stub
		return image2;
	}
	
	public Image getImage3() {
		// TODO Auto-generated method stub
		return image3;
	}
	
	public Image getImage4() {
		// TODO Auto-generated method stub
		return image4;
	}
	
	public Image getImage5() {
		// TODO Auto-generated method stub
		return image5;
	}
	
	public Image getImage6() {
		// TODO Auto-generated method stub
		return image6;
	}
	public Image getImage7() {
		// TODO Auto-generated method stub
		return image7;
	}
	
	public Image getImage8() {
		// TODO Auto-generated method stub
		return image8;
	}
	
	public Image getImage9() {
		// TODO Auto-generated method stub
		return image9;
	}
	
	public Image getImage10() {
		// TODO Auto-generated method stub
		return image10;
	}
	
	public Image getImage11() {
		// TODO Auto-generated method stub
		return image11;
	}
	
	public Image getImage12() {
		// TODO Auto-generated method stub
		return image12;
	}
	
	public Image getImage13() {
		// TODO Auto-generated method stub
		return image13;
	}
	
	
	


}
