    import java.awt.Image;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import java.nio.channels.ShutdownChannelGroupException;
    
    import javax.imageio.ImageIO;
    
    public class IP1 extends OpenBB{
        
        private Image image,image2,image3,image4;
        private int[] histogram,histogram2;
        
        public IP1(){
            
            try {
                
                image = ImageIO.read(new File("ThS1.jpg"));
                histogram = calHistogram(image);
                
                int[][] imageMatrix = imageToMatrix((BufferedImage)image);
                
                int[][] im = imageMatrix;
                for(int i=0 ; i<imageMatrix.length; i++){
                    for(int j=0; j<imageMatrix[0].length;j++){
                    if(imageMatrix[i][j]>100)im[i][j] = 0;
                    else im[i][j] = 255;
                }
            }
            image2 = matrixToImage("ThS1_bin", im);
            
            // ----- homework 1 part c -------
            image3 = ImageIO.read(new File("ThS2.jpg"));
            histogram2 = new int[256];
            for(int i=0; i<255; i++)
                histogram2[i]= 0;
            int[][] imageMatrix2 = imageToMatrix((BufferedImage)image3);
            for(int i=0 ; i<imageMatrix2.length; i++){
                for(int j=0; j<imageMatrix2[0].length;j++){
                    histogram2[imageMatrix2[i][j]]++;
                }
            }
            int[][] im2 = imageMatrix2;
            for(int i=0 ; i<imageMatrix2.length; i++){
                for(int j=0; j<imageMatrix2[0].length;j++){
                    if(imageMatrix2[i][j]>120)im2[i][j] = 255;
                    else im2[i][j] = 0;
                }
            }
            image4 = matrixToImage("ThS2_bin", im2);
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }



public Image getImage(){
    return image;
}
public int[] getImageHistogram(){
    return histogram;
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
public int[] getImageHistogram2(){
    return histogram2;
}

}