/* Karthik Lella
 * Gallatin 4
 * 2/29/2016
 */
 
/**
 * Class used to implement slice objects
 */
class Slice{
	int startAngle = 90;
	String name;
	String data;
	double percent;
	
	/**
	 * Creates a slice object
	 * @param n the name of the field
	 * @param d the fields details
	 * @param p the percent the field takes up
	 */
	public Slice(String n, String d, double p){
		name = n;
		data = d;
		percent = p;		
	}	
	/**
	 * Retuns the calculated angle
	 * @return the angle
	 */
	public int getAngle(){
		return (int)((percent/100)*360);
	}
	/**
	 * Returns the percent
	 * @return the percent
	 */
	public double getPercent(){
		return percent;
	}
	/**
	 * Creates a string version of the slice
	 * @return a string version of the slice
	 */
	public String toString(){
		return "     Name: " + name + "\n     Data: " + data + "\n     Takes up " + percent + "% of the pie    \n\n";
	}
	/**
	 * Retuens teh name of the slice
	 * @return the name of the slice
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns the slcie's details
	 * @return the details fo the slice
	 */
	public String getData(){
		return data;
	}
}
