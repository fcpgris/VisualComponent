package com.eric.VisualComponentEditor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String jsonFilename = "vc.json";
	
	private List<VisualComponent> visualComponents = new ArrayList<VisualComponent>();

	public CenterPanel() {
		File jsonFile = new File(jsonFilename);
		if (jsonFile.exists() == false)
			return;

		InputStream input;
		try {
			input = new FileInputStream(jsonFilename);
			VisualComponent[] vcArray = JsonUtils.objectMapper.readValue(input, VisualComponent[].class);
			if(vcArray == null || vcArray.length == 0)
				return;
			
			visualComponents =  new ArrayList<VisualComponent>(Arrays.asList(vcArray));
		} catch (Exception e) {
			System.out.println("Failed to read content of json file: " + jsonFilename);
			e.printStackTrace();
			return;
		}
	}
	
	public List<VisualComponent> getVisualComponents() {
		return visualComponents;
	}

	public void setVisualComponents(List<VisualComponent> visualComponents) {
		this.visualComponents = visualComponents;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (VisualComponent visualComponent : visualComponents) {
			drawVisualComponent(g, visualComponent);
		}
	}
	
	private void drawVisualComponent(Graphics g, VisualComponent vc) {
		BufferedImage img;
		try {
			img = ImageIO.read(new File(vc.getImagePath()));
			g.drawImage(img, (int)vc.getPoint().getX(), (int)vc.getPoint().getY(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
