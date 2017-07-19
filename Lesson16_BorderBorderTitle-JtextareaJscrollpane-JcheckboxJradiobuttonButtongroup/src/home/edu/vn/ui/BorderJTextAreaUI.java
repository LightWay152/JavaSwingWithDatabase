package home.edu.vn.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BorderJTextAreaUI extends JFrame{
	JTextField txtName;
	JTextArea txtAddress;
	Button btnOK;
	
	public BorderJTextAreaUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnInfo=new JPanel();
		pnMain.add(pnInfo);
		
		pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.Y_AXIS));
		JPanel pnName=new JPanel();
		pnName.setLayout(new FlowLayout());
		JLabel lblName=new JLabel("Enter name:");
		txtName=new JTextField(20);
		
		pnName.add(lblName);
		pnName.add(txtName);
		pnInfo.add(pnName);
		
		JPanel pnAddress=new JPanel();
		pnAddress.setLayout(new FlowLayout());
		JLabel lblAddress=new JLabel("Address:");
		txtAddress=new JTextArea(5,19);
		
		txtAddress.setWrapStyleWord(true);
		txtAddress.setLineWrap(true);
		
		JScrollPane sc=new JScrollPane(txtAddress,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnAddress.add(lblAddress);
		pnAddress.add(sc);
		pnInfo.add(pnAddress);
		
		Border borderInfo=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitleInfo=new TitledBorder(borderInfo, "Info:");
		pnInfo.setBorder(borderTitleInfo);
		borderTitleInfo.setTitleColor(Color.RED);
		borderTitleInfo.setTitleJustification(TitledBorder.LEFT);
		
		
		JPanel pnOK=new JPanel();
		pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOK=new Button("OK");
		pnOK.add(btnOK);
		pnMain.add(pnOK);
		
		lblAddress.setPreferredSize(lblName.getPreferredSize());
		
	}
	public void addEvents()
	{
		
	}
	public void showWindow()
	{
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
