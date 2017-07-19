package home.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame {
	public MyWindow(String title)
	{
		//super(title);
		this.setTitle(title);//like super(title) statement
		
		addControls();
	}
	public void addControls()
	{
		//get class include window:
		Container con=getContentPane();
		//Create 1 class include control
		JPanel pn=new JPanel();
		pn.setBackground(Color.BLUE);
		
		JButton btn=new JButton("This is statment button");
		pn.add(btn);
		
		//show panel on display:
		con.add(pn);
	}
	public void showWindow()
	{
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//exit when click on X at corner of window
		this.setLocationRelativeTo(null);//located at center of desktop' screen
		this.setResizable(false);
		this.setVisible(true);//display window on desktop's screen
	}
}
