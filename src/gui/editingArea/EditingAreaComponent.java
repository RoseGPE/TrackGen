package gui.editingArea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

import util.Drawable;

@SuppressWarnings("serial")
public class EditingAreaComponent extends JComponent {

	private EditingArea area;
	
	public EditingAreaComponent(EditingArea area){
		this.area = area;
		
		setPreferredSize(area.getSize());
		setMaximumSize(area.getSize());
		
		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				// Periodically asks Java to repaint this component
				try {
					while (true) {
						Thread.sleep(10);
						repaint();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(repainter).start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		this.area.draw(g);
		List<Drawable> drawableParts = this.area.getDrawableParts();
		for (Drawable d : drawableParts) {
			d.draw(g);
		}
	}

}
