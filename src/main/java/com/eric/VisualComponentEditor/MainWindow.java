package com.eric.VisualComponentEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTree visualComponentTree = null;
	private JScrollPane leftPanel = null;
	private CenterPanel centerPanel = null;
	private JSplitPane splitPane = null;
	
	
	
	public MainWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Visual Editor");
		setSize(1200, 900);
		
		centerPanel = new CenterPanel();
		centerPanel.setSize(800, 800);
		centerPanel.setTransferHandler(new PanelTransferHandler());

		// createTree
		visualComponentTree = createTree();
		leftPanel = new JScrollPane(visualComponentTree);
		leftPanel.setMinimumSize(new Dimension(400, 800));
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
		add(splitPane, BorderLayout.CENTER);
	}

	private JTree createTree() {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("¿Ø¼þ");
		
		DefaultMutableTreeNode category1 = new DefaultMutableTreeNode("BS");
		DefaultMutableTreeNode bs1 = new DefaultMutableTreeNode(new VisualComponent("BS1", "figures/vc/bs1.png"));
		DefaultMutableTreeNode bs2 = new DefaultMutableTreeNode(new VisualComponent("BS2", "figures/vc/bs2.jpg"));
		category1.add(bs1);
		category1.add(bs2);
		top.add(category1);
		DefaultTreeModel treeModel = new DefaultTreeModel(top);
		JTree tree = new JTree(treeModel);
		tree.setDragEnabled(true);
		tree.setCellRenderer(new VisualEditorTreeCellRenderer());
		tree.setTransferHandler(new TreeTransferHandler());
		return tree;
	}

}
