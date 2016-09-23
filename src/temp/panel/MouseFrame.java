package temp.panel;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;

class MouseFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7858323729125472527L;

	public MouseFrame() {
		
		setTitle("create rectangle..");
		setSize(600, 300);
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		Container contentPane = getContentPane();
		contentPane.add(new MousePanel());
	}
	
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		JFrame frame = new MouseFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
