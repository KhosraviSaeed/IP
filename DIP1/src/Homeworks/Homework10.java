package Homeworks;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework10 extends OpenBB{
	
	private Image street,street2,street3,street4,street5;
	//396*621
	private int[][] st,st2,st3,st4,st5;
	//target 300*444

	public Homework10(){
		
		try {
			street = ImageIO.read(new File("street.jpg"));
			st = new int[396][621];
			st = imageToMatrix((BufferedImage)street);
			st2 = new int[396][621];
			st3 = new int[396][621];
			st4 = new int[396][621];
			st5 = new int[396][621];
			street3 = drawCircle(290,445,50);
			street2 = putMask();
			street4 = andIt();
			street5 = finilize();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private Image finilize() {
		int[][] p = new int[396][621];
		int[][] p2 = new int[396][621];
		for(int i=0; i<396; i++){
			for(int j=0; j<621; j++){
				
				p[i][j] = (int)(st[i][j]*0.8);
				p2[i][j] = (int)(st4[i][j]*1.1);
				if(st4[i][j]==0)st5[i][j]=p[i][j];
				else st5[i][j]=p2[i][j];
			}
		}
		
		Image test = matrixToImage("test", st5);
		return test;
	}

	private Image andIt() {
		//And st3 and st
		for(int i=0; i<396; i++){
			for(int j=0; j<621; j++){
				
				if(st3[i][j]==255) st4[i][j] = st[i][j];
				else
					st4[i][j] = 0;
				
			}
		}
		street4 = matrixToImage("test", st4);
		return street4;
	}
	
	

	

	public Image putMask(){
		int[][] p = new int[396][621];
		for(int i=0; i<396; i++){
			for(int j=0; j<621; j++){
					if(st3[i][j]==1 || st3[i][j]==255)
						st3[i][j]=255;
			}
		}
		
		for(int i=0; i<396; i++){
			for(int j=0; j<621; j++){
				if(st3[i][j]==0)p[i][j]=st[i][j];
				else if(st3[i][j]==255)p[i][j]=0;
			}
		}
		
		
		return matrixToImage("test",p);
		
		
	}
	
	public Image drawCircle(int x, int y, int r){
		int[][] p = new int[396][621];
		final double PI = 3.1415926535;
	    double angle, x1, y1;
	    
	    for(int i=0; i<396; i++){
	    	for(int j=0; j<621; j++){
	    		p[i][j] = 255;
	    	}
	    }

	    for(double i = 0; i < 360; i += 0.01){
	            angle = i;
	            x1 = r * Math.cos(angle * PI / 180);
	            y1 = r * Math.sin(angle * PI / 180);
	            p[(int)(x+x1)][(int)(y+y1)] = 1;
	      }
	    for(int i=0; i<396; i++){
	    	for(int j=0; j<621; j++){
	    		if(p[i][j]==255)p[i][j]=0;
	    		else
	    		if(p[i][j]==1) j = 621;
	    		
	    	}
	    }
	    for(int i=390; i>=0; i--){
	    	for(int j=620; j>=0; j--){
	    		if(p[i][j]==255)p[i][j]=0;
	    		else
	    		if(p[i][j]==1) j = 0;
	    		
	    	}
	    }
	    	st3 = p;
	      return matrixToImage("test",p);
	}
	
	public Image getImage(){
		return street;
	}
	public Image getImage2(){
		return street2;
	}
	public Image getImage3(){
		return street3;
	}
	
	public Image getImage4(){
		return street4;
	}
	
	public Image getImage5(){
		return street5;
	}
	
	
}
