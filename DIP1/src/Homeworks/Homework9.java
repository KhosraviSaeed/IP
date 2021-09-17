package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework9 extends OpenBB{
	
	private Image input1,input2,output;
	private int[][] inp1,inp2,out;
	
	public Homework9(){
		
		try {
			int m = 0;
			input1 = ImageIO.read(new File("input1.jpg"));
			input2 = ImageIO.read(new File("input2.jpg"));
			inp1 = new int[400][357];
			inp2 = new int[400][357];
			
			inp1 = imageToMatrix((BufferedImage)input1);
			inp2 = imageToMatrix((BufferedImage)input2);
			int[] l1 = new int[357];
			int[] l2 = new int[357];
			boolean b = false;
			
			for(int i=0; i<400; i++){
				
				for(int k =0; k<357; k++)
				l1[k] = inp1[i][k];
				
				for(int j =0; j<400; j++){
					for(int k=0; k<357; k++){
						l2[k] = inp2[j][k];
					}
					if(equalsTo(l1, l2)){
					System.out.print("("+i+","+j+")"+equalsTo(l1, l2)+"-\n");
						b = false;
						
					}
					
					if(!b && m==0){
						m = i;
						b = true;
					}
				}
				
				
			}
			out = new int[m+400][357];
			for(int i=0; i<400+m; i++){
				for(int j=0; j<357; j++){
					
					if(i<m){
						out[i][j] = inp1[i][j];
					}else{
						if(i>m && i<400){
							if(inp1[i][j]+inp2[i-m][j]>255){
								out[i][j] = 255;
							}else
						out[i][j] = inp1[i][j]+inp2[i-m][j];
						}else{
							out[i][j] = inp2[i-m][j];
						}
					}
					
				}
			}
			
			output = matrixToImage("P9_out1",out);
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public Image getImageI1(){
		return input1;
	}
	public Image getImageI2(){
		return input2;
	}
	
	public Image getImageO(){
		return output;
	}
	
	public boolean equalsTo(int[] l1, int[] l2){
		
		for(int i=0; i<l1.length; i++){
			if(l1[i]!=l2[i]){
				return false;
			}
		}
		return true;
		
	}
}
