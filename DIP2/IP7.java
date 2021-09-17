import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IP7 extends OpenBB{
	
	
	BufferedImage image,image2,image3,image4,image5,image6;
	
	public IP7(){
		
		try {
			image = ImageIO.read(new File("lena.jpg"));
			image2 = ImageIO.read(new File("barbara.jpg"));
			image3 = hide(image, image2,1);
			image4 = hide(image, image2,2);
			image5 = hide(image, image2,3);
			image6 = reveal(image5, 3);
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
	public Image getImage5(){
		return image5;
	}
	public Image getImage6(){
		return image6;
	}
	

}
