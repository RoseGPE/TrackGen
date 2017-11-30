package gui.editingArea;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EditingAreaPanel extends JPanel{
	
	public EditingAreaPanel(){
		EditingArea area = new EditingArea(600,600);
		EditingAreaComponent areaComponent = new EditingAreaComponent(area);
		area.addLinkedBezierCurve();
		add(areaComponent);
	}

}
