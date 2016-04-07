/* Karthik Lella
 * Gallatin 4
 * 2/29/2016
 */

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import javax.swing.*;

/**
 * Creates a pie chart component that combines tghe pie 
 * chart and the slice classes
 */
class PieChartComponent extends JComponent{
	
	private PieChart pc;
	private ArrayList<String> names;
	private ArrayList<String> data;
	int numElements;
	private ArrayList<Double> percentList;
	private Slice[] slices;
	private Color[] colors;
	
	/**
	 * Creates a pie chart component object with given values
	 * @param n the number of slices
	 * @param nameList the names of the slices
	 * @param dataList the information of the slices
	 * @param l the percents of the slices
	 */
	public PieChartComponent(int n,ArrayList<String> nameList,ArrayList<String> dataList,ArrayList<Double> l){
		numElements = n;
		pc = new PieChart(50,50,600);
		names = nameList;
		data = dataList;
		percentList = l;
		slices = new Slice[numElements];
		colors = new Color[7];
		
		for(int i = 0; i < numElements; i++){
			slices[i] = new Slice(names.get(i),data.get(i),percentList.get(i));
		}
				
		fillColorArray();
	}		
	/**
	 * Paints the components
	 * @param g the graphics used to draw the components
	 */
	public void paint(Graphics g){	
		drawPie(g,slices);	
	}
	void drawPie(Graphics g, Slice[] s){
		int x = pc.getX();
		int y = pc.getY();
		int radius = pc.getRadius();
		int startAngle = 0;
		int curValue = 0;
		
		g.drawOval(x,y,radius,radius);
		for(int i = 0; i < s.length; i++){
			startAngle = (int)(curValue*360/100);
			int arcAngle = (int)(s[i].getAngle());
			g.setColor(colors[i]);
			g.fillArc(x,y,radius,radius,startAngle,arcAngle);
			curValue += s[i].getPercent();
		}
	}
	/**
	 * Private method to fill the array of colors with various colors
	 */
	private void fillColorArray(){
		colors[0] = Color.RED;
		colors[1] = Color.ORANGE;
		colors[2] = Color.YELLOW;
		colors[3] = Color.GREEN;
		colors[4] = Color.BLUE;
		colors[5] = Color.CYAN;
		colors[6] = Color.MAGENTA;		
	}	
	/**
	 * Retuens the number of elements
	 * @return the number of elements
	 */
	public int getNumElements(){
		return numElements;
	}
	/**
	 * Returns the array of slices
	 * @return the array of slices
	 */
	public Slice[] getSliceInfo(){
		return slices;
	}
}