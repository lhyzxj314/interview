package temp.panel;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MousePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485469280620383913L;
	private static final int SQUARE_LENGTH = 10;
	private int current = Integer.MIN_VALUE;
	//private int s_num = 0;
	private List<Point> squares = new ArrayList<Point>(100);

	public MousePanel() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				if (evt.getClickCount() >= 2) {
					int x = evt.getX();
					int y = evt.getY();
					current = find(x, y);
					if (current >= 0) {
						removeRec(current);
					}
				} else {
					int x = evt.getX();
					int y = evt.getY();
					current = find(x, y);
					if (current < 0) {
						add(x, y);
					}
				}
			}
		});
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Point s : squares) {
			g.drawRect(s.x - SQUARE_LENGTH / 2, s.y - SQUARE_LENGTH / 2, SQUARE_LENGTH, SQUARE_LENGTH);
		}
	}
	
	private void removeRec(int i) {
		if (i >= squares.size() || i < 0) return;
		squares.remove(i);
		if (current == i)
			current = -1;
		repaint();
	}

	private void add(int x, int y) {
		squares.add(new Point(x, y));
		current = squares.size();
		repaint();
	}

	private int find(int x, int y) {
		int i = -1;
		for (Point s : squares) {
			if (x <= s.x + SQUARE_LENGTH / 2 && x >= s.x - SQUARE_LENGTH / 2
					   && y <= s.y + SQUARE_LENGTH / 2 && y >= s.y - SQUARE_LENGTH / 2) {
				i = squares.indexOf(s);
			}
		}
		return i;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
