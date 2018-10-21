package com.eric.VisualComponentEditor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class VisualEditorTreeCellRenderer extends DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    ImageIcon groupedIcon;
    ImageIcon unGroupedIcon;

	VisualEditorTreeCellRenderer() {
		setTextSelectionColor(Color.white);
        setBackgroundSelectionColor(Color.blue);
        setBorderSelectionColor(Color.black);
        setBackgroundNonSelectionColor(new Color(238, 238,
                244));
        
        setLeafIcon(new ImageIcon("figures/vc/images.png"));
    }
    
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf,
                row, hasFocus);
		System.out.println("value=" + value);
		
        Object o = ((DefaultMutableTreeNode) value).getUserObject();
        if (o instanceof VisualComponent) {
        	System.out.println("class: VisualComponent");
            VisualComponent vc = (VisualComponent) o;
            setIcon(new ImageIcon(vc.getImagePath()));
        }
		return this;
	}

}
