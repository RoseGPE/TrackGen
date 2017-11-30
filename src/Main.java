import java.io.File;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.editingArea.EditingAreaPanel;
import processing.SaveHandler;
import util.LinkedBezierCurve;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel eAPanel = new EditingAreaPanel();
		frame.add(eAPanel);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// TODO Auto-generated method stub
		/*
		System.out.println("Opening File");
		File file = new File("test.zip");
		ArrayList<CubicCurve2D> output = SaveHandler.loadTrackDataFromFile(file);
		System.out.println(output.get(0).getX1() + " " + output.get(1).getX2());
		System.out.println("Closing File");
		*/
	}

}
