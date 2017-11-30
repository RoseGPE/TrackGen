package gui.editingArea;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Drawable;
import util.LinkedBezierCurve;

public class EditingArea implements Drawable {

	private BufferedImage backgroundImage;
	private ArrayList<LinkedBezierCurve> linkedBezierCurves;
	private int width, height;
	
	public EditingArea(int width, int height){
		this.linkedBezierCurves = new ArrayList<LinkedBezierCurve>();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		if(this.backgroundImage != null){
			g2.drawImage(this.backgroundImage,0,0,this.backgroundImage.getWidth(),this.backgroundImage.getHeight(),null);
		}
		g2.dispose();
		
	}
	
	public List<Drawable> getDrawableParts(){
		return new ArrayList<Drawable>(this.linkedBezierCurves);
	}
	
	public void addLinkedBezierCurve(){
		LinkedBezierCurve curve1 = new LinkedBezierCurve(100.0,200.0, 300.0,200.0, 100.0,0.0, 150.0,Math.PI*0.6);
		LinkedBezierCurve curve2 = new LinkedBezierCurve(curve1, 500.0, 200.0, 100.0, Math.PI);
		this.linkedBezierCurves.add(curve1);
		this.linkedBezierCurves.add(curve2);
	}
	
	public Dimension getSize() {
		return new Dimension(this.width, this.height);
	}

}
