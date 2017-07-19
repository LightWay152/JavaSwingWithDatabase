package home.edu.vn.ui;

import java.awt.Button;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutUI extends JFrame{
	public BoxLayoutUI(String title)
	{	
		super(title);
		addControls();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnBoxLayout=new JPanel();
		pnBoxLayout.setLayout(new BoxLayout(pnBoxLayout, BoxLayout.Y_AXIS));
		
		Button btn1=new Button("Demo button 1");
		Button btn2=new Button("Demo button 2");
		Button btn3=new Button("Demo button 3");
		Button btn4=new Button("Demo button 4");
		
		pnBoxLayout.add(btn1);
		pnBoxLayout.add(btn2);
		pnBoxLayout.add(btn3);
		pnBoxLayout.add(btn4);
		
		con.add(pnBoxLayout);
	}
	public void showWindow()
	{
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
