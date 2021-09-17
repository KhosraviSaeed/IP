package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import javax.imageio.ImageIO;

public class OpenBB {
	
	public Image makeGray(String name,BufferedImage img)
	{
	    for (int x = 0; x < img.getWidth(); ++x)
	    for (int y = 0; y < img.getHeight(); ++y)
	    {
	        int rgb = img.getRGB(x, y);
	        int r = (rgb >> 16) & 0xFF;
	        int g = (rgb >> 8) & 0xFF;
	        int b = (rgb & 0xFF);

	        int grayLevel = (r + g + b) / 3;
	        int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
	        img.setRGB(x, y, gray);
	    }
	    
	    File output=new File(name+".bmp");
		try {
			ImageIO.write(img,"bmp",output);
			}catch (Exception e){
				e.printStackTrace();
				}
		
		return img;
	}
	
	public BufferedImage matrixToImage(String name,int[][] gray){
		//BufferedImage.TYPE_BYTE_GRAY = BufferedImage.TYPE_INT_RGB + makeGray();
		int w=gray.length;
		int h=gray[0].length;
		BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				Color c = new Color(gray[i][j], gray[i][j], gray[i][j]);
				image.setRGB(i, j, c.getRGB());
			}
		}
		makeGray(name,image);
		return image;

	}
	
	
	public int[][] imageToMatrix(BufferedImage im){

		try{
			Raster raster=im.getData();
			int w=raster.getWidth(),h=raster.getHeight();
			int pixels[][]=new int[w][h];
			for(int x=0;x<w;x++){
				for(int y=0;y<h;y++){
					pixels[x][y]=raster.getSample(x,y,0);
					}
			}
			return pixels;
			}catch(Exception e){
			e.printStackTrace();
			}return null;
	}
	
	public static String integerToBinary (int n, int numOfBits) {
		   String binary = "";
		   for(int i = 0; i < numOfBits; ++i, n/=2) {
		      switch (n % 2) {
		         case 0:
		            binary = "0" + binary;
		         case 1:
		            binary = "1" + binary;
		      }
		   }

		   return binary;
		}
	
	public int binaryToInteger(String binary) {
	    char[] numbers = binary.toCharArray();
	    int result = 0;
	    for(int i=numbers.length - 1; i>=0; i--)
	        if(numbers[i]=='1')
	            result += Math.pow(2, (numbers.length-i - 1));
	    return result;
	}
	
	public String ANDBinaries(String s1, String s2) {
		String a = null;
		System.out.println(s1+"/"+s2);
		for(int i=0; i<s1.length(); i++){
			if(s1.charAt(i)=='1' && s2.charAt(i)=='1'){
				a += '1';
			}else
				a += '0';
		}
		
		return a;
	}

}
