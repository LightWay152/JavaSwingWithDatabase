package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class LearnJTreeUI extends JFrame {
	DefaultMutableTreeNode root=null;
	JTree tree;
	public LearnJTreeUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnTree=new JPanel();
		pnTree.setLayout(new BorderLayout());
		root=new DefaultMutableTreeNode("Topica Edumall");
		tree=new JTree(root);
		DefaultMutableTreeNode nodePhtgv=new DefaultMutableTreeNode("Phòng hợp tác giảng viên");
		root.add(nodePhtgv);
		DefaultMutableTreeNode nodeNv1=new DefaultMutableTreeNode("Nguyễn Hồng Đào");
		nodePhtgv.add(nodeNv1);
		DefaultMutableTreeNode nodeNv2=new DefaultMutableTreeNode("Hồ Thành Công");
		nodePhtgv.add(nodeNv2);
		
		DefaultMutableTreeNode nodePhkd=new DefaultMutableTreeNode("Phòng hợp kinh doanh");
		root.add(nodePhkd);
		DefaultMutableTreeNode nodeNv3=new DefaultMutableTreeNode("Huỳnh Thừa Kế");
		nodePhkd.add(nodeNv3);
		
		DefaultMutableTreeNode nodePhkt=new DefaultMutableTreeNode("Phòng hợp kế toán");
		root.add(nodePhkt);
		
		tree.expandRow(0);
		
		
		
		JScrollPane sc=new JScrollPane(tree,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTree.add(sc,BorderLayout.CENTER);
		
		con.setLayout(new BorderLayout());
		pnTree.setPreferredSize(new Dimension(300,0));
		
		JPanel pnRight=new JPanel();
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnTree,pnRight);
		sp.setOneTouchExpandable(true);
		con.add(sp,BorderLayout.CENTER);
	}
	public void addEvents()
	{
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//getLastSelectedPathComponent chính là Node trên giao diện được chọn
				Object obj=tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode nodeSelected=(DefaultMutableTreeNode) obj;
				JOptionPane.showMessageDialog(null, nodeSelected.getUserObject()+"");
			}
		});
	}
	public void showWindow()
	{
		this.setSize(new Dimension(800,600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
