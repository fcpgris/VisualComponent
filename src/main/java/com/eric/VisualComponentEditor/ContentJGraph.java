package com.eric.VisualComponentEditor;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class ContentJGraph extends mxGraphComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContentJGraph(mxGraph graph) {
		super(graph);
		this.graph = graph;
		
//		Object parent = graph.getDefaultParent();
//		graph.getModel().beginUpdate();
//		try {
//			String a = mxConstants.SHAPE_IMAGE;
//			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30, "defaultVertex;shape=image;image=file:/bs1.png;rotation=45.0");
//			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
//			graph.insertEdge(parent, null, "Edge", v1, v2);
//		} finally {
//			graph.getModel().endUpdate();
//		}
	}
	
}
