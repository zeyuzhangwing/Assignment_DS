package guiFrame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class drawFrame {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
			
		JFrame frame = new JFrame("Broad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JToolBar toolBar = new JToolBar();
			toolBar.setBounds(6, 6, 65, 415);
			frame.getContentPane().add(toolBar);
			
				circleButton circleButton = new circleButton("Click me!");
				circleButton.setText("       ");
				toolBar.add(circleButton);
			
			//frame.setSize(300, 150);
			frame.setVisible(true);

}
}
