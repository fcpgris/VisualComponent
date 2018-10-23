package com.eric.VisualComponentEditor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;

public class CenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String jsonFilename = "vc.json";
	
	private List<VisualComponent> visualComponents = new ArrayList<VisualComponent>();

	public CenterPanel() {
//		File jsonFile = new File(jsonFilename);
//		if (jsonFile.exists() == false)
//			return;
//
//		InputStream input;
//		try {
//			input = new FileInputStream(jsonFilename);
//			VisualComponent[] vcArray = JsonUtils.objectMapper.readValue(input, VisualComponent[].class);
//			if(vcArray == null || vcArray.length == 0)
//				return;
//			
//			visualComponents =  new ArrayList<VisualComponent>(Arrays.asList(vcArray));
//		} catch (Exception e) {
//			System.out.println("Failed to read content of json file: " + jsonFilename);
//			e.printStackTrace();
//			return;
//		}
		createJGraph();
	}
	
	private void createJGraph() {
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		
		// get graph stylesheet
//	    mxStylesheet stylesheet = graph.getStylesheet();

	    // define image style name
//	    String myStyleName = "myImageStyle";

	    // define image style           
//	    Hashtable<String, Object> style = new Hashtable<String, Object>();
//	    style.put( mxConstants.STYLE_SHAPE, mxConstants.SHAPE_IMAGE);
//	    style.put( mxConstants.STYLE_IMAGE, "file:/c:/bs1.png");
//	    style.put( mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_BOTTOM);

//	    stylesheet.putCellStyle( myStyleName, style);

		graph.getModel().beginUpdate();
		try {
			String a = mxConstants.SHAPE_IMAGE;
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30, "defaultVertex;shape=image;image=file:/bs1.png;rotation=45.0");
			
//			Map<String, Object> v1Style = graph.getCellStyle(v1);
//			if(v1Style.containsKey("rotation") == true) {
//				Double originalRotation = Double.parseDouble((String)v1Style.get("rotation"));
//				double newRotation = originalRotation + 45d;
//				v1Style.put("rotation", newRotation);
//				System.out.println("rotation updated");
//				graph.setCellStyle("rotation=90", new Object[] {v1});
//			}
			
			
			
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);
		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		add(graphComponent);
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
