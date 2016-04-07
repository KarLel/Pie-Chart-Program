/* Karthik Lella
 * Gallatin - 2
 * 2/29/2016
 */

/**
 * Creates the pie cahrt class
 */
public class PieChart{	
	int startX;
	int startY;
	int radius;
	
	/**
	 * Creates an outline for the pie chart
	 */
	public PieChart(){
		startX = 0;
		startY = 0;
		radius = 0;
	}
	/**
	 * Creates an outline for the pie chart with given values
	 * @param x the starting x value
	 * @param y the starting y value
	 * @param r the radius of the circle
	 */
	public PieChart(int x, int y, int r){
		startX = x;
		startY = y;
		radius = r;
	}
	/**
	 * returns x pos
	 * @return x pos
	 */	
	public int getX(){
		return startX;
	}
	/**
	 * returns y pos
	 * @return y pos
	 */		
	public int getY(){
		return startY;
	}
	/**
	 * sets the x pos
	 * @param x pos
	 */		
	public void setX(int x){
		startX = x;
	}	
	/**
	 * sets the y pos
	 * @param y pos
	 */	
	public void setY(int y){
		startY = y;
	}	
	/**
	 * returns the radius
	 *@return teh radius
	 */
	public int getRadius(){
		return radius;
	}
	/**
	 * sets the radius
	 * @param r the radius to set
	 */	
	public void setRadius(int r){
		radius = r;
	}				
}