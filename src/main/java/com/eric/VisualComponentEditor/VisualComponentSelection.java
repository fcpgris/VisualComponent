package com.eric.VisualComponentEditor;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class VisualComponentSelection implements Transferable {

    private static final DataFlavor[] flavors = {
    		new DataFlavor(VisualComponent.class, "Visual Component")
        };
    
    private VisualComponent vc;
    
    public VisualComponentSelection(VisualComponent vc) {
    	this.vc = vc;
	}

    public DataFlavor[] getTransferDataFlavors() {
		 return (DataFlavor[])flavors.clone();
	}

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (int i = 0; i < flavors.length; i++) {
            if (flavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
	}

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
        if (flavor.equals(flavors[0])) {
            return (Object)vc;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
	}

}
