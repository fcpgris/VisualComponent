package com.eric.VisualComponentEditor;

import java.awt.datatransfer.DataFlavor;
import javax.swing.TransferHandler;

public class PanelTransferHandler extends TransferHandler  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean canImport(TransferHandler.TransferSupport info) {
        // Check for String flavor
        if (!info.isDataFlavorSupported(new DataFlavor(VisualComponent.class, "Visual Component"))) {
            return false;
        }
        System.out.println("Drop supported!");
        return true;
   }
	public boolean importData(TransferHandler.TransferSupport info) {
		System.out.println("importing data");
		//TODO insert cells
		return true;
	}
	
}
