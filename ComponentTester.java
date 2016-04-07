/* Karthik Lella
 * Gallatin - 2
 * 2/29/2016
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Creates the inal frame where everything comes together
 * @author karth
 *
 */
public class ComponentTester extends JFrame implements MouseListener{
	private PieChartComponent pcc;	
	private JPanel panel;
	private JTextArea textArea;
	private JLabel label;
	private Slice[] sliceInfo;
	
	/**
	 * Creates the final frame
	 * @param p the PieChartComponent to draw
	 */
	public ComponentTester(PieChartComponent p){
    	setSize(800,800);
		setTitle("Your Pie is ready!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setForeground(Color.LIGHT_GRAY);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		panel = new JPanel();
		label = new JLabel("Click the pie chart for more detailed information!");
		label.setFont(new Font("", Font.BOLD, 50));
		
		pcc = p;
		sliceInfo = pcc.getSliceInfo();
		
		textArea = new JTextArea();
		textArea.setForeground(Color.LIGHT_GRAY);
		pcc.addMouseListener(this);
		add(pcc);
		panel.add(textArea);
		add(panel, BorderLayout.EAST);
		add(label, BorderLayout.SOUTH);
		setVisible(true);
	}
	/**
	 * Activates when the mouse is clicked
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(pcc))
		{
			String s = "";
			for(int i = 0; i < sliceInfo.length; i++){
				s+=sliceInfo[i].toString();
			}
			textArea.setText(s);
		}
	}
	/**
	 * Activates when the mouse is entered
	 */
	public void mouseEntered(MouseEvent e) {
	}
	/**
	 * Activates when the mouse is exited
	 */
	public void mouseExited(MouseEvent e) {
	}
	/**
	 * Activates when the mouse is pressed
	 */
	public void mousePressed(MouseEvent e) {
	}
	/**
	 * Activates when the mouse is released
	 */
	public void mouseReleased(MouseEvent e) {
	}
}