package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework6  extends OpenBB{
	
	private int[] bsize = {4,8,16,32};
	private Image girl;
	private int[][] girlP;
	private Image[] girls;
	
	public Homework6(){
		
		try {
			girls = new Image[bsize.length];
			girl = ImageIO.read(new File("girl.jpg"));
			girlP = new int[512][512];
			girlP = imageToMatrix((BufferedImage)girl);
			for(int b = 0; b<bsize.length; b++){
				
				for(int i=0; i<512; i+= bsize[b]){
					for(int j=0; j<512; j+= bsize[b]){
						
						
							int Ave = 0;
							for(int p= i; p<i+(bsize[b]);p++){
								for(int q= j; q<j+(bsize[b]);q++){
									Ave += girlP[p][q];
								}
							}
							for(int p= i; p<i+(bsize[b]);p++){
								for(int q= j; q<j+(bsize[b]);q++){
									if((int)(Ave/(bsize[b]*bsize[b]))>255)girlP[p][q]= 255;
									else if((int)(Ave/(bsize[b]*bsize[b]))<0)girlP[p][q] = 0;
									else
									girlP[p][q] = (int)(Ave/(bsize[b]*bsize[b]));
								}
							}
						
					}
				}
				
				girls[b] = matrixToImage("girl_"+bsize[b],girlP);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public Image getImage(int i){
		return girls[i-1];
	}
	
}
