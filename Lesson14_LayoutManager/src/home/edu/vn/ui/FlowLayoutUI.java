package home.edu.vn.ui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutUI extends JFrame{
	public FlowLayoutUI(String title)
	{
		super(title);
		addControls();
	}
	public void addControls()
	{
		Container con=getContentPane();
		
		//Create 1 JPanel:
		JPanel pnFlowLayout=new JPanel();
		pnFlowLayout.setLayout(new FlowLayout());
		
		JButton btn1=new JButton("Demo button 1");
		JButton btn2=new JButton("Demo button 2");
		JButton btn3=new JButton("Demo button 3");
		JButton btn4=new JButton("Demo button 4");
		
		pnFlowLayout.add(btn1);
		pnFlowLayout.add(btn2);
		pnFlowLayout.add(btn3);
		pnFlowLayout.add(btn4);
		
		con.add(pnFlowLayout);
	}
	public void showWindow()
	{
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
