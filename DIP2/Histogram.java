import java.awt.Color;
import java.awt.Graphics;

public class Histogram {
	
	private int[] histogram;
	private Graphics g;

	public Histogram(int[] his, Graphics gra,int x, int y, int l){
		histogram = his;
		g = gra;
		int max = maxElementInArray(histogram);
		int t = max/l;
		int[] up = new int[histogram.length];
		for(int i=0; i<histogram.length; i++){
			if(t!=0)
			up[i] = histogram[i]/t;
			else
				if(t==0)
					up[i] = 0;
		}
		g.setColor(Color.BLACK);
		for(int i=0; i<up.length;i++){
			g.drawLine(x+i, y-up[i], x+i,y);
		}
		
		
	}
	
	public int maxElementInArray(int[] arr){
		int max = 0;
		for(int i=0; i<arr.length;i++){
			if(arr[i]>max)max = arr[i];
		}
		return max;
	}
	
	
}
