package com.eric.VisualComponentEditor;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.TransferHandler;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class PanelTransferHandler extends TransferHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean canImport(TransferHandler.TransferSupport info) {
        // Check for String flavor
        if (!info.isDataFlavorSupported(new DataFlavor(VisualComponent.class, "Visual Component"))) {
            return false;
        }
        System.out.println("Drop supported!");
        return true;
   }
	
	public boolean importData(TransferHandler.TransferSupport info) {
        if (!info.isDrop()) {
            return false;
        }
        
        System.out.println("start dropping ...");
        
        Transferable t = info.getTransferable();
        VisualComponent vc = null;
        try {
			if(t.getTransferData(new DataFlavor(VisualComponent.class, "Visual Component")) instanceof VisualComponent) {
				vc = (VisualComponent) t.getTransferData(new DataFlavor(VisualComponent.class, "Visual Component"));
				vc.setPoint(info.getDropLocation().getDropPoint());
				System.out.println("drop vc: " + vc.toString());
				
				//TODO add vc to draw data structure
				CenterPanel panel = (CenterPanel)info.getComponent();
				VisualComponent newObject = (VisualComponent)vc.clone();
				try {
					panel.getVisualComponents().add(newObject);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
//				panel.getVisualComponents().add(newObject);
				saveVisualComponents(panel.getVisualComponents());
			    panel.repaint();
			    return true;
			}else {
				System.out.println("Cannot drop Object which isn't a VisualComponent class");
				return false;
			}
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private void saveVisualComponents(List<VisualComponent> vcs) {
		try {
			JsonUtils.objectMapper.writeValue(
				    new FileOutputStream("vc.json"), vcs);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
