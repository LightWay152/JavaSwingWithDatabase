package home.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LearnJTabbedPaneUI extends JFrame {
	
	JTabbedPane tab;
	
	public LearnJTabbedPaneUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		Container con=getContentPane();
		tab=new JTabbedPane();
		con.add(tab);
		
		JPanel pnTab1=new JPanel();
		JPanel pnTab2=new JPanel();
		JPanel pnTab3=new JPanel();
		tab.add(pnTab1,"Cấu hình");
		tab.add(pnTab2,"Bảo mật");
		tab.add(pnTab3,"Phân quyền");
		
		pnTab1.setBackground(Color.RED);
		pnTab2.setBackground(Color.BLUE);
		pnTab3.setBackground(Color.YELLOW);
		
		pnTab1.add(new JButton("Đây là button"));
		pnTab2.add(new JTextField(15));
	}
	public void showWindow()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
