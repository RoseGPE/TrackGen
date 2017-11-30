package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class LinkedBezierCurve implements Drawable {

	private LinkedBezierCurve parentCurve, childCurve;
	private double x1, x2, y1, y2, mag1, mag2, dir1, dir2;

	// Constructors

	public LinkedBezierCurve() {
		this.parentCurve = null;
		this.childCurve = null;
	}

	public LinkedBezierCurve(LinkedBezierCurve parentCurve) {
		this.parentCurve = parentCurve;
		this.childCurve = null;
	}

	public LinkedBezierCurve(LinkedBezierCurve parentCurve, double x2, double y2, double mag2, double dir2) {
		this.parentCurve = parentCurve;
		this.parentCurve.setChildCurve(this);
		this.childCurve = null;
		this.x1 = this.parentCurve.getX2();
		this.x2 = x2;
		this.y1 = this.parentCurve.getY2();
		this.y2 = y2;
		this.mag1 = this.parentCurve.getMag2();
		this.mag2 = mag2;
		this.dir1 = this.parentCurve.getDir2() + Math.PI;
		this.dir2 = dir2;
	}

	public LinkedBezierCurve(double x1, double y1, double x2, double y2, double mag1, double dir1, double mag2,
			double dir2) {
		this.parentCurve = null;
		this.childCurve = null;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.mag1 = mag1;
		this.mag2 = mag2;
		this.dir1 = dir1;
		this.dir2 = dir2;
	}

	// Functionality
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(new Color(0, 0, 0));
		CubicCurve2D.Double curve = new CubicCurve2D.Double(this.x1, this.y1, this.x1 + this.mag1 * Math.cos(this.dir1),
				this.y1 + this.mag1 * Math.sin(this.dir1), this.x2 + this.mag2 * Math.cos(this.dir2),
				this.y2 + this.mag2 * Math.sin(this.dir2), this.x2, this.y2);

		Line2D.Double m1 = new Line2D.Double(this.x1, this.y1, this.x1 + this.mag1 * Math.cos(this.dir1) * 0.8,
				this.y1 + this.mag1 * Math.sin(this.dir1) * 0.8);

		Line2D.Double m2 = new Line2D.Double(this.x2, this.y2, this.x2 + this.mag2 * Math.cos(this.dir2) * 0.8,
				this.y2 + this.mag2 * Math.sin(this.dir2) * 0.8);

		g2.draw(curve);
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 6 }, 0);
		g2.setStroke(dashed);
		g2.draw(m1);
		g2.draw(m2);
		if (this.childCurve != null) {
			this.adjustDir2(this.dir2 + Math.PI * 0.0015);
		}
		g2.dispose();
	}

	// Getters

	public LinkedBezierCurve getParentCurve() {
		return this.parentCurve;
	}

	public LinkedBezierCurve getChildCurve() {
		return this.childCurve;
	}

	public double getX1() {
		return this.x1;
	}

	public double getX2() {
		return this.x2;
	}

	public double getY1() {
		return this.y1;
	}

	public double getY2() {
		return this.y2;
	}

	public double getMag1() {
		return this.mag1;
	}

	public double getMag2() {
		return this.mag2;
	}

	public double getDir1() {
		return this.dir1;
	}

	public double getDir2() {
		return this.dir2;
	}

	// Setters

	public void setChildCurve(LinkedBezierCurve child) {
		this.childCurve = child;
	}

	public void setParentCurve(LinkedBezierCurve parent) {
		this.parentCurve = parent;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public void setMag1(double mag1) {
		this.mag1 = mag1;
	}

	public void setMag2(double mag2) {
		this.mag2 = mag2;
	}

	public void setDir1(double dir1) {
		this.dir1 = dir1;
	}

	public void setDir2(double dir2) {
		this.dir2 = dir2;
	}

	// Adjusters

	public void adjustX1(double x1) {
		this.x1 = x1;
		if (this.parentCurve != null) {
			this.parentCurve.setX1(x2);
		}
	}

	public void adjustX2(double x2) {
		this.x2 = x2;
		if (this.childCurve != null) {
			this.childCurve.setX1(x2);
		}
	}

	public void adjustY1(double y1) {
		this.y1 = y1;
		if (this.parentCurve != null) {
			this.parentCurve.setY2(y1);
		}
	}

	public void adjustY2(double y2) {
		this.y2 = y2;
		if (this.childCurve != null) {
			this.childCurve.setY1(y2);
		}
	}

	public void adjustDir1(double dir1) {
		this.dir1 = dir1 % (2 * Math.PI);
		if (this.parentCurve != null) {
			this.parentCurve.setDir2((dir1 + Math.PI) % (2 * Math.PI));
		}
	}

	public void adjustDir2(double dir2) {
		this.dir2 = dir2 % (2 * Math.PI);
		if (this.childCurve != null) {
			this.childCurve.setDir1((dir2 + Math.PI) % (2 * Math.PI));
		}
	}

	public void adjustMag1(double mag1) {
		this.mag1 = mag1;
		if (this.parentCurve != null) {
			this.parentCurve.setMag2(mag1);
		}
	}

	public void adjustMag2(double mag2) {
		this.mag2 = mag2;
		if (this.childCurve != null) {
			this.childCurve.setMag1(mag2);
		}
	}

}
