/* Karthik Lella
 * Gallatin - 2
 * 2/29/2016
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

@SuppressWarnings("serial")
/**
 * Creates the welcome frame
 * @author karth
 */
public class IntroFrame extends JFrame implements MouseListener, ActionListener{
	
	private JPanel panel;
	private JTextField numElements;
	private JButton addButton;
	/**
	 * Creates the welcome frame	
	 */
	public IntroFrame(){
		panel = new JPanel();
		numElements = new JTextField("How many elements are there?  ");
		addButton = new JButton("Add");
		
		numElements.addMouseListener(this);
		addButton.addMouseListener(this);
		numElements.addActionListener(this);
		addButton.addActionListener(this);
		
		setTitle("Mixing Ingredients!");
		setSize(350, 70);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.add(numElements);
		panel.add(addButton);	
		
		add(panel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	/**
	 * Returns the number of elements
	 * @return the number of elements
	 */
	public int getNumElements(){
		return Integer.parseInt(numElements.getText());
	}
	/**
	 * MouseEvent when the mouse is clicked
	 */
	public void mouseClicked(MouseEvent e) {		
		if(e.getSource().equals(numElements)){
			if(numElements.getText().equals("How many elements are there?  "))
				numElements.setText("");
		}	
	}
	/**
	 * MouseEvent when the mouse enters a component
	 */
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(addButton))
			addButton.setForeground(Color.BLUE);
	}
	/**
	 * MouseEvent when the mouse exits a component
	 */
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(addButton))
			addButton.setForeground(Color.BLACK);
	}
	/**
	 * Not used
	 */
	public void mousePressed(MouseEvent e) {
	}
	/**
	 * Not used
	 */
	public void mouseReleased(MouseEvent e) {
	}
	/**
	 * ActionEvent completes an action
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addButton)){
			if(getNumElements()>0){
				dispose();
				InstantiateFrame frame = new InstantiateFrame(getNumElements());
			}
			else
				JOptionPane.showMessageDialog(null,"Please Enter a value greater than 0");
		}
	}
	/**
	 * Main method for staring the program
	 */
	public static void main(String[] args){
		IntroFrame frame = new IntroFrame();
	}
}
