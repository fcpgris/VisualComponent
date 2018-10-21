package com.eric.VisualComponentEditor;

import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeTransferHandler extends TransferHandler {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getSourceActions(JComponent c) {
	    return COPY;
	}
	
	protected Transferable createTransferable(JComponent c) {
		JTree tree = (JTree) c;
		DefaultMutableTreeNode selectTreeNode = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		Object userData = selectTreeNode.getUserObject();
		if(userData instanceof VisualComponent) {
			VisualComponent vc = (VisualComponent) userData;
			System.out.println(vc.toString());
			return new VisualComponentSelection(vc);
		}

		return new VisualComponentSelection(new VisualComponent());
	}
	
//	public boolean canImport(TransferHandler.TransferSupport info) {
//        // Check for String flavor
//        if (!info.isDataFlavorSupported(new DataFlavor(VisualComponent.class, "Visual Component"))) {
//            return false;
//        }
//        System.out.println("Drop supported!");
//        return true;
//   }
}
