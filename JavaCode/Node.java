import java.util.Comparator;

public class Node {
	
	private int y , x; 
	private double distance ; 
	
	Node(String x, String y, String mainx,String mainY){
		this.x = Integer.parseInt(x); 
		this.y = Integer.parseInt(y);
		getDistance(mainx,mainY); 
	}
	
	public double getdistance() {
		return distance; 
	}
	
	public String getData() {
		return x+", "+y+", "+distance; 
	}
	
	private  void getDistance(String mainX, String mainY) {	
		int mainx = Integer.parseInt(mainX);
		int mainy = Integer.parseInt(mainY); 
		distance = Math.hypot((x-mainx), (y-mainy)); 
	}
}



