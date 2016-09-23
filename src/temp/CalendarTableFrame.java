package temp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTable;

public class CalendarTableFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1627545209543095708L;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 150;
	
	private Object[][] cell = {{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
			{null, null, new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)},
            {new Integer(6), new Integer(7), new Integer(8), new Integer(9), new Integer(10), new Integer(11), new Integer(12)},
            {new Integer(13), new Integer(14), new Integer(15), new Integer(16), new Integer(17),new Integer(18), new Integer(19)},
            {new Integer(20), new Integer(21), new Integer(22), new Integer(23), new Integer(24), new Integer(25), new Integer(26)},
            {new Integer(27), new Integer(28), new Integer(29), new Integer(30), new Integer(31), null, null}};

	private String[] title = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
	public CalendarTableFrame() {
		setTitle("Calendar");
		setSize(WIDTH, HEIGHT);
		JTable table = new JTable(cell, title);
		getContentPane().add(table, BorderLayout.CENTER);
	}
	
	
	
	
	
}
