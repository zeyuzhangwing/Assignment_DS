package guiFrame;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.ScrollPane;

public class drawFrame {

	private static JFrame frame;
	public static ImageIcon icon;
	private static JToolBar toolBar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
			
		JFrame frame = new JFrame("Broad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			toolBar_1 = new JToolBar();
			toolBar_1.setOrientation(SwingConstants.VERTICAL);
			toolBar_1.setBounds(6, 6, 50, 393);
			frame.getContentPane().add(toolBar_1);
			addButtons(toolBar_1);
			
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setBounds(62, 6, 545, 393);
			frame.getContentPane().add(scrollPane);
			
			addMenu();
			
			
			//frame.setSize(300, 150);
			frame.setVisible(true);

}	
	protected static void addMenu()
	{
		//Mean bar create
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		//one menu group name file
		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_A);
		menuFile.getAccessibleContext().setAccessibleDescription(
		        "File operation menu");
		menuBar.add(menuFile);
		
		JMenuItem menuItem = new JMenuItem("Save",KeyEvent.VK_S);//set hot key?
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "Save file");
		menuFile.add(menuItem);
		menuFile.addSeparator();
		
		
		menuItem = new JMenuItem("Save as",
                new ImageIcon("circle.png"));// can set the icon here, need to find some image resoucre
		menuFile.add(menuItem);
		menuFile.addSeparator();

		//menu for operation 
		JMenu menuOperation = new JMenu("Operation");// this many need to rename
		menuOperation.setMnemonic(KeyEvent.VK_O);
		menuOperation.getAccessibleContext().setAccessibleDescription(
		        "User operation");
		menuBar.add(menuOperation);
	
		JMenuItem menuItem2 = new JMenuItem("Quite",KeyEvent.VK_Q);//set hot key?
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.ALT_MASK));
		menuItem2.getAccessibleContext().setAccessibleDescription(
		        "QUITE");
		menuOperation.add(menuItem2);
		menuOperation.addSeparator();
		
		
		menuItem2 = new JMenuItem("Save as",
                new ImageIcon("circle.png"));// can set the icon here, need to find some image resoucre
		menuOperation.add(menuItem2);
		menuOperation.addSeparator();
		
		
		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menuFile.add(menuItem);
	}
	protected static void addButtons(JToolBar toolBar)
	{
		//--------------------Button 0-------------------------
		JButton cb2 = new JButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
	
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(cb2);
		toolBar_1.addSeparator();
		//--------------------Button 1-------------------------
		JButton cb = new JButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		toolBar.add(cb);
		toolBar_1.addSeparator();
		//--------------------Button 2-------------------------
		JButton cb1 = new JButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		
		toolBar.add(cb1);
		toolBar_1.addSeparator();
		//--------------------Button 3-------------------------
		JButton cb3 = new JButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		toolBar_1.add(cb3);
		toolBar_1.addSeparator();
		//--------------------Button 4-------------------------
		JButton cb4 = new JButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
	
		cb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		toolBar.add(cb4);
		toolBar_1.addSeparator();
		//--------------------Button 5-------------------------
		JButton cb5 = new JButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
	
		cb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(cb5);
		toolBar_1.addSeparator();
	
	}
	
	
}
