package Homeworks;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Homework5  extends OpenBB{
	
	public Image bird8,bird7,bird6,bird5,bird4,bird3,bird2,bird1;
	public int[][] b8,b7,b6,b5,b4,b3,b2,b1;
	public Homework5(){
		
		try {
			bird8 = ImageIO.read(new File("bird.bmp"));
			b8 = new int[991][637];
			b7 = new int[991][637];
			b6 = new int[991][637];
			b5 = new int[991][637];
			b4 = new int[991][637];
			b3 = new int[991][637];
			b2 = new int[991][637];
			
			b8 = imageToMatrix((BufferedImage)bird8);
			bird7 = shiftLike("P5_out7",b8,2);
			b7 = imageToMatrix((BufferedImage)bird7);
			bird6 = shiftLike("P5_out6",b7,4);
			b6 = imageToMatrix((BufferedImage)bird6);
			bird5 = shiftLike("P5_out5",b6,8);
			b5 = imageToMatrix((BufferedImage)bird5);
			bird4 = shiftLike("P5_out4",b5,16);
			b4 = imageToMatrix((BufferedImage)bird4);
			bird3 = shiftLike("P5_out3",b4,32);
			b3 = imageToMatrix((BufferedImage)bird3);
			bird2 = shiftLike("P5_out2",b3,64);
			b2 = imageToMatrix((BufferedImage)bird2);
			bird1 = shiftLike("P5_out1",b2,128);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	public Image shiftLike(String name,int[][] b, int k){
		
		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[0].length; j++){
				
				if(b[i][j]%k != 0){
					int z = b[i][j]%k;
					b[i][j] = b[i][j] - z;
				}
				
			}
		}
		
		return matrixToImage(name,b);
	}
	
	
	
	public Image getImage(int i){

		switch (i) {
		case 1:
			return bird1;
		case 2:
			return bird2;
		case 3:
			return bird3;
		case 4:
			return bird4;
		case 5:
			return bird5;
		case 6:
			return bird6;
		case 7:
			return bird7;
		case 8:
			return bird8;
		default:
			return null;
		}
		
	}
	
}
