package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;

public class LearnJSplitPaneUI extends JFrame{
	public LearnJSplitPaneUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnLeft=new JPanel();
		pnLeft.setPreferredSize(new Dimension(200,0));
		JPanel pnRight=new JPanel();
		pnRight.setLayout(new BorderLayout());
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		sp.setOneTouchExpandable(true);
		con.add(sp);
		
		JPanel pnRight1=new JPanel();
		JPanel pnRight2=new JPanel();
		JSplitPane spRight=new JSplitPane(
				JSplitPane.VERTICAL_SPLIT,pnRight1,pnRight2);
		spRight.setOneTouchExpandable(true);
		pnRight1.setPreferredSize(new Dimension(0,200));
		pnRight.add(spRight,BorderLayout.CENTER);
	}
	public void addEvents()
	{
		
	}
	public void showWindow()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
