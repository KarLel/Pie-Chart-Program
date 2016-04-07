/* Karthik Lella
 * Gallatin - 2
 * 2/29/2016
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 * Class that instantiates after the welcome frame terminates
 * @author karth
 */
public class InstantiateFrame extends JFrame implements MouseListener, KeyListener{
	private String names;
	private double percent;
	private String data;
	private ArrayList<JTextField> fields;
	private JPanel panel;
	private int n;

	/**
	 * Creates a frame that has a specific number of slices
	 * @param numElements the specific number of slices
	 */
	public InstantiateFrame(int numElements){
		names = "";
		data = "";
		percent = 0;
		fields = new ArrayList<JTextField>(numElements*3);
		panel = new JPanel();
		n = numElements;
		
		while(numElements > 0){
			fields.add(new JTextField("Element title"));
			fields.add(new JTextField("Element description"));
			fields.add(new JTextField("Percent of whole"));
			numElements--;
		}
			
		setTitle("Baking the Pie!     -> Press ENTER when done <-");
		setSize(500, n*(50));
		GridLayout grid = new GridLayout(n,3,0,5);
		setLayout(grid);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(JTextField a: fields){
			a.addMouseListener(this);
			a.addKeyListener(this);
			add(a);
		}
		
		setVisible(true);
	}
	/**
	 * Activates when the mouse clicks something
	 */
	public void mouseClicked(MouseEvent e) {
		for(JTextField j: fields){
			if(e.getSource().equals(j)){
				j.setText("");
			}
		}
	}	
	/**
	 * Activates when the mouse enters something
	 */
	public void mouseEntered(MouseEvent e) {
	}
    /**
     * Activates when the mouse ecits something
     */
	public void mouseExited(MouseEvent e) {
	}
	/**
	 * Activates when the mouse presses something
	 */
	public void mousePressed(MouseEvent e) {
	}
	/**
	 * Activates when the mouse releases something
	 */
	public void mouseReleased(MouseEvent e) {
	}
	/**
	 * Activates when a key is pressed
	 */
	public void keyPressed(KeyEvent e){
	}
	/**
	 * Activates when a key is released
	 */
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			int currentPercent = 0;
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> data = new ArrayList<String>();
			ArrayList<Double> percents = new ArrayList<Double>();

			for(int i = 2; i < fields.size(); i+=3)
				currentPercent+=Integer.parseInt(fields.get(i).getText());
			if(currentPercent>100){
				JOptionPane.showMessageDialog(null, "Values cannot exceed 100 percent");
			}
			else{
				for(int i = 0; i < fields.size(); i+=3)
					names.add(fields.get(i).getText());
				for(int i = 1; i < fields.size(); i+=3)
					data.add(fields.get(i).getText());
				for(int i = 2; i < fields.size(); i+=3)
					percents.add(Double.parseDouble((fields.get(i).getText())));						
				
				ComponentTester tester = new ComponentTester(new PieChartComponent(n,names,data,percents));
				dispose();				
			}	
		}
	}
	/**
	 * Activates when a key is typed
	 */
	public void keyTyped(KeyEvent e){
	}
}