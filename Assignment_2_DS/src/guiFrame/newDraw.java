package guiFrame;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class newDraw {

	
	private static  JToolBar toolBar_1;
	private static Graphics2D g;
	private static String toolSelected;
	// used for eraser
	private static final Color backGroundColor = Color.WHITE;
	//eraser size now is pre set should change
	private static int eW = 20;
	private static int eH = 20;
	private static int count = 0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newDraw window = new newDraw();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	 newDraw() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setSize(754, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 imgG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
		 imgG2.setStroke(new BasicStroke(3));
		 
		 	toolBar_1 = new JToolBar();
			toolBar_1.setOrientation(SwingConstants.VERTICAL);
			toolBar_1.setBounds(3, 6, 66, 393);
			frame.getContentPane().add(toolBar_1);
			addButtons(toolBar_1);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("10");
			toolBar_1.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("20");
			toolBar_1.add(rdbtnNewRadioButton_1);
			
			
			panel.setBackground(Color.WHITE);
			panel.setBounds(81, 6, 520, 411);
			
			
				panel.addMouseListener(drawer);
				panel.addMouseMotionListener(drawer);
			
				
		       
		    frame.getContentPane().add(panel);
			
			
			JToolBar toolBar = new JToolBar();
			toolBar.setOrientation(SwingConstants.VERTICAL);
			toolBar.setBounds(613, 6, 125, 411);
			frame.getContentPane().add(toolBar);
			
			JTextPane txtpnChatArea = new JTextPane();
			txtpnChatArea.setBackground(Color.LIGHT_GRAY);
			txtpnChatArea.setText("Chat area");
			toolBar.add(txtpnChatArea);
			
			//Mean bar create
			JMenuBar menuBar = new JMenuBar();
			addMenue(menuBar);
			frame.setJMenuBar(menuBar);
			//one menu group name file
			frame.setVisible(true);
	}
	
	static BufferedImage img = new BufferedImage(520, 411, BufferedImage.TYPE_INT_ARGB);
	static Graphics2D  imgG2 = img.createGraphics();
    boolean rButtonDown;
    JFrame frame = new JFrame("Broad");
    static JPanel panel = new JPanel() {
		protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	         Graphics2D graph = (Graphics2D) g.create();
	         //getting the panel weight and height
	         int w = img.getWidth();
	         int h = img.getHeight();
	         //draw 
	       
	         graph.drawImage(img, 0, 0, w, h, null);
	         
	         // this color need to change once we have multiple color choose
	         graph.setColor(Color.BLACK);
	         
	        
	     }
		public Dimension getPreferredSize() {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    };
    
    //
	  MouseAdapter drawer = new MouseAdapter() {
	        boolean rButtonDown;
	        Point preV;

	        @Override
	        public void mousePressed(MouseEvent e) {
	        	//free draw
	        	if(toolSelected == "pencil")
	        	{
		            //if (SwingUtilities.isLeftMouseButton(e)) {
		                preV = e.getPoint();
		               // System.out.println("X: " + e.getX());
		            //}
		            //if (SwingUtilities.isRightMouseButton(e) && !rButtonDown) {
		                // (This just behaves a little better
		                // than using the mouseClicked event.)
		              // rButtonDown  = true;
		                //currentColor = (currentColor + 1) % colors.length;
		                panel.repaint();
		               
		          //  }
	        	}
	        	else if(toolSelected == "eraser")
	        	{
	        		// if (SwingUtilities.isLeftMouseButton(e)) {
			                preV = e.getPoint();
			             //   System.out.println("X: " + e.getX());
			            //}
			           // if (SwingUtilities.isRightMouseButton(e) && !rButtonDown) {
			                // (This just behaves a little better
			                // than using the mouseClicked event.)
			             //   rButtonDown  = true;
			                //currentColor = (currentColor + 1) % colors.length;
			                panel.repaint();
			               
			            //}
	        	}
	            
        }

	        @Override
	        public void mouseDragged(MouseEvent e) {
		        	if(toolSelected == "pencil")
		        	{
		            //if (preV != null) {
		                Point  next = e.getPoint();
		                
		                imgG2.setColor(Color.black);
		                imgG2.drawLine(preV.x, preV.y, next.x, next.y);
		                panel.repaint();
		                preV = next;
		                
		            //	}
	        		}
		        	else if(toolSelected == "eraser")
		        	{
		           
		                Point  next = e.getPoint();
		                
		               // imgG2.setColor(backGroundColor);
		                imgG2.setBackground(backGroundColor);
		                imgG2.clearRect(preV.x, preV.y, eH, eW);
		                panel.repaint();
		                preV = next;
		                
		            	
	        		}
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
		        
		          /*  if (SwingUtilities.isLeftMouseButton(e)) {
		                preV = null;
		            }
		            if (SwingUtilities.isRightMouseButton(e)) {
		                rButtonDown = true;
		            }*/
		        	}
	        
	    };
	 
	 

	protected static void addMenue(JMenuBar menuBar)
	  {
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
	  
	
	//all button url need to change, in order to get in local
	protected static void addButtons(JToolBar toolBar)

	{
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		
		
		
		//--------------------Button 0-------------------------
		JToggleButton cb2 = new JToggleButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
	
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(cb2);
		btnGroup.add(cb2);
		toolBar_1.addSeparator();
		//--------------------Button 1-------------------------
		JToggleButton cb = new JToggleButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		toolBar.add(cb);
		btnGroup.add(cb);
		toolBar_1.addSeparator();
		//--------------------Button 2-------------------------
		JToggleButton cb1 = new JToggleButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		
		toolBar.add(cb1);
		btnGroup.add(cb1);
		toolBar_1.addSeparator();
		//--------------------Button 3-------------------------
		JToggleButton cb3 = new JToggleButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/circle.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		btnGroup.add(cb3);
		toolBar_1.add(cb3);
		toolBar_1.addSeparator();
		//--------------------eraser-------------------------
		JToggleButton cb5 = new JToggleButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/Eraser.png").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		cb5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			    toolSelected = "eraser";
			  
			}
		});
					
		
		toolBar.add(cb5);
		btnGroup.add(cb5);
		toolBar_1.addSeparator();
		//--------------------Button 4-------------------------
		
		JToggleButton cb4 = new JToggleButton(new ImageIcon(((new ImageIcon(
	            "/Users/tomyu/git/Assignment_2_DS/img/sketch-pencil-icon-doodle-style-illustration-33305001.jpg").getImage()
	            .getScaledInstance(30, 30,
	                    java.awt.Image.SCALE_SMOOTH)))));
		count =0;
		cb4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				toolSelected = "pencil";
					
			}
		
		});
		toolBar.add(cb4);
		btnGroup.add(cb4);
		toolBar_1.addSeparator();
		
	}
}
