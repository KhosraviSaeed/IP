import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.Arrays;

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
	    
	    saveFile(name,img);
	    
		
		return img;
	}
	
	public void saveFile(String name, BufferedImage img){
		File output=new File(name+".bmp");
		try {
			ImageIO.write(img,"bmp",output);
			}catch (Exception e){
				e.printStackTrace();
				}
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
	
	public void showMatrix(double[][] mat){
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j] + ",        ");
			}
			System.out.println();
		}
	}
	
	public void showArray(int[] arr){
		for(int i=0; i<arr.length;i++){
			if(i%40 == 0)
				System.out.println();
			System.out.print(arr[i]+ " ");
		}
	}
	
	public int[] calHistogram(Image image){
		int[] histogram = new int[256];
		for(int i=0; i<255; i++)
			histogram[i]= 0;
		int[][] imageMatrix = imageToMatrix((BufferedImage)image);
		for(int i=0 ; i<imageMatrix.length; i++){
			for(int j=0; j<imageMatrix[0].length;j++){
				histogram[imageMatrix[i][j]]++;
			}
		}
		return histogram;
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
	public int c_hs , d_hs;
	public int[][] histogramStreching(int[] his1,int[][] imageMatrix){
		int[] his2 = new int[his1.length];
		int a = 0;
		int b = 255;
		int c = 0; 
		int d = 0;
		for(int i=255; i>0; i--)
			if(his1[i]>100){
				c = i-1;
			}
		for(int i=0; i<255; i++)
			if(his1[i]>100){
				d = i+1;
			}
		
		
		int w = imageMatrix.length;
		int h = imageMatrix[0].length;
		int[][] im = new int[w][h];
		for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
				im[i][j] = (int)(imageMatrix[i][j] - c)*((b-a)/(d-c)) + a;
				if(im[i][j]>255)im[i][j] = 255;
				if(im[i][j]<0)im[i][j] = 0;
			}
		}
		c_hs = c;
		d_hs = d;
		return im;
	}
	public int getcc(){
		return c_hs;
	}
	public int getdd(){
		return d_hs;
	}

	public int[][] multCToImagePixels(int[][] ip, double c){
		int[][] ip2 = new int[ip.length][ip[0].length];
		for(int i=0; i<ip.length; i++){
			for(int j=0; j<ip[0].length; j++){
				ip2[i][j] = (int)(ip[i][j] * c);
				if(ip2[i][j]>255) ip2[i][j]=255;
				if(ip2[i][j]<0) ip2[i][j]=0;
			}
		}
		return ip2;
	}
	
	public int[][] logNormalization(int[][] ip, double c){
		int[][] ip2 = new int[ip.length][ip[0].length];
		for(int i=0; i<ip.length; i++){
			for(int j=0; j<ip[0].length; j++){
				ip2[i][j] = (int)(c * Math.log(ip[i][j] + 1)); 
				if(ip2[i][j]>255)ip2[i][j] = 255;
				if(ip2[i][j]<0)ip2[i][j] = 0;
			}
		}
		
		return ip2;
	}
	
	public int[][] powerLaw(int[][] ip, double c,double gamma){
		int[][] ip2 = new int[ip.length][ip[0].length];
		for(int i=0; i<ip.length; i++){
			for(int j=0; j<ip[0].length; j++){
				ip2[i][j] = (int)(c * Math.pow(ip[i][j],gamma)); 
				if(ip2[i][j]>255)ip2[i][j] = 255;
				if(ip2[i][j]<0)ip2[i][j] = 0;
			}
		}
		
		return ip2;
	}
	
	
	public double[][] equalize(int[][] src, int max){
	    double[][] ip = new double[max][5];
	    double sum, total;
	    total = src.length* src[0].length;
	    for(int p = 0; p<max; p++){
	    	ip[p][0] = p;
	    	sum = 0;
	    	for(int i=0;i<src.length; i++){
	    		for(int j=0; j<src[0].length; j++){
	    			if(src[i][j] == (p*255/(max-1)))sum++;
	    			
	    		}
	    	}
	    	ip[p][1] = sum/total;
	    }
	    for(int i=0; i<max; i++){
	    	sum = 0;
	    	for(int j=i; j>=0; j--){
	    		sum += ip[j][1];
	    	}
	    	ip[i][2] = sum;
	    }
	    
	    for(int i=0; i<max; i++){
	    	ip[i][3] = Math.round((ip[i][2]*(max - 1)));
	    }
	    for(int i=0; i<max; i++){
	    	sum = 0;
	    	for(int j=0; j<max; j++){
	    		if((int)ip[j][3] == i)sum+= ip[j][1];
	    	}
	    	ip[i][4] = sum;
	    }
	    
	    return ip;
	}
	BufferedImage Equalize(BufferedImage src){
	    BufferedImage nImg = new BufferedImage(src.getWidth(), src.getHeight(),
	                         BufferedImage.TYPE_BYTE_GRAY);
	    WritableRaster wr = src.getRaster();
	    WritableRaster er = nImg.getRaster();
	    int totpix= wr.getWidth()*wr.getHeight();
	    int[] histogram = new int[256];

	    for (int x = 0; x < wr.getWidth(); x++) {
	        for (int y = 0; y < wr.getHeight(); y++) {
	            histogram[wr.getSample(x, y, 0)]++;
	        }
	    }

	    int[] chistogram = new int[256];
	    chistogram[0] = histogram[0];
	    for(int i=1;i<256;i++){
	        chistogram[i] = chistogram[i-1] + histogram[i];
	    }

	    float[] arr = new float[256];
	    for(int i=0;i<256;i++){
	        arr[i] =  (float)((chistogram[i]*255.0)/(float)totpix);
	    }

	    for (int x = 0; x < wr.getWidth(); x++) {
	        for (int y = 0; y < wr.getHeight(); y++) {
	            int nVal = (int) arr[wr.getSample(x, y, 0)];
	            er.setSample(x, y, 0, nVal);
	        }
	    }
	    nImg.setData(er);
	    return nImg;
	}
	
	public Object[][] doubleToObject(double[][] ip){
		Object[][] ob = new Object[ip.length][ip[0].length];
		for(int i=0; i<ip.length;i++){
			for(int j=0; j<ip[0].length; j++){
				ob[i][j] =ip[i][j];
			}
		}
		return ob;
	}
	
	
	public int[][] HistogramMatching(int[][] src,int[][] src2){
		
		double[][] t = equalize(src,256);
	
		double[][] t2 = equalize(src2,256);
		
		double[][] t3 = new double[256][3];
		for(int i=0; i<256; i++){
			t3[i][0] = t[i][3];
			t3[i][1] = t2[i][3];
		}
		
		
		for(int i=0; i<256; i++){
			for(int j=255;j>0;j--){
				if(t3[i][0]<=t3[j][1]){
					t3[i][2] = j;
				}
			}
		}
		int[][] output = src;
		for(int i=0; i<src.length; i++){
			for(int j=0; j<src[0].length; j++){
				output[i][j] = (int)t3[src[i][j]][2];
			}
		}
		
		int[] histogram = new int[256];
		return output;
	}
	
	
	public static int blurPixels(int[][] origPixels, int left, int top, int right, int bottom) {
        //transperency is not considered
        int alpha = 0xff000000, red = 0, green = 0, blue = 0;
        int boxSize = (right - left) * (bottom - top);
 
        //the following nested for loops takes the sum of RGB components of each
        //pixels in the box.
        for (int q = top; q < bottom; q++) {
            for (int p = left; p < right; p++) {
                int pixel = origPixels[p][q];
                red += ((pixel >> 16) & 0xff);
                green += ((pixel >> 8 ) & 0xff);
                blue += ((pixel) & 0xff);
            }
        }
        //average is computed using integer arithmetic. If the box size is too large
        //this routine will fail. max box size = (INT_Max/256) = 8,388,608
        red /= boxSize;
        green /= boxSize;
        blue /= boxSize;
        //returns the reconstructed pixel back
        return (alpha | (red << 16) | (green << 8 ) | blue);
    }
	
	public double[][] intToDouble(int[][] in){
		double[][] out = new double[in.length][in[0].length];
		for(int i=0; i<in.length;i++){
			for(int j=0; j<in[0].length; j++){
				out[i][j] = (double)in[i][j];
			}
		}
		
		return out;
	}
	
	public int[][] doubleToInt(double[][] in){
		int[][] out = new int[in.length][in[0].length];
		for(int i=0; i<in.length;i++){
			for(int j=0; j<in[0].length; j++){
				out[i][j] = (int)in[i][j];
				if(out[i][j]>255)out[i][j]=255;
			}
		}
		
		return out;
	}
	
	
	public double[][] convolve(int[][] in, double[][] k){
		double[][] out = new double[in.length][in[0].length];
		double sum;
		int zeroi,zeroj;
		for(int i=0; i<out.length; i++){
			for(int j=0; j<out[0].length; j++){
				if(i!=0 && i!=out.length-1){
					if(j!=0 && j!=out[0].length-1){
						sum = 0;
						zeroi = i-1;
						zeroj = j-1;
						for(int p=0; p<k.length; p++){
							for(int q=0; q<k[0].length;q++){
								//System.out.println(in[zeroi+p][zeroj+q]);
								sum+= k[p][q]*in[zeroi+p][zeroj+q];
							}
						}
						//System.out.println(sum);
						out[i][j] = sum;
						if(out[i][j]>255)out[i][j] = 255;
						if(out[i][j]<0)out[i][j] = 0;
					}
				}
			}
		}
		return out;
	}
	
	// Hide the first i MSB of pixelB in pixelA
	private int hidePixel(int pixelA, int pixelB, int i) {
		return pixelA & 0xFFF8F8F8 | (pixelB & 0x00E0E0E0) >> (8-i);
	}

	// Extract the last i LSB
	private int revealPixel(int pixel, int i) {
		return (pixel & 0xFF070707) << (8-i);
	}

	// Hide hiddenImage into coverImage
	public BufferedImage hide(BufferedImage imageSource, BufferedImage imageToHide, int k) {
		int width = imageSource.getWidth();
		int height = imageSource.getHeight();
		BufferedImage imageResult = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				imageResult.setRGB(i, j, hidePixel(imageSource.getRGB(i, j), imageToHide.getRGB(i, j),k));
			}
		}
		
		return imageResult;
	}

	// Reveal hidden image into resultImage
	public BufferedImage reveal(BufferedImage imageSource, int k) {
		BufferedImage imageResult = new BufferedImage(512, 512, BufferedImage.TYPE_BYTE_GRAY);
		int width = imageResult.getWidth();
		int height = imageResult.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				imageResult.setRGB(i, j, revealPixel(imageSource.getRGB(i, j),k));
			}
		}
		return imageResult;
	}
	
	
}
