package com.eric.VisualComponentEditor;

import java.awt.Point;

public class VisualComponent implements Cloneable{

	private String name;
	private String imagePath;
	private Point point;

	public VisualComponent() {

	}

	public VisualComponent(String name, String imagePath) {
		this.name = name;
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		VisualComponent vc = (VisualComponent)super.clone();
		vc.setPoint((Point)point.clone());
		return vc;
	}
}
