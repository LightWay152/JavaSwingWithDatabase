package home.edu.vn.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BorderJTextAreaCheckBoxRadioUI extends JFrame{
	JTextField txtName;
	JTextArea txtAddress;
	Button btnOK;
	
	JCheckBox chkGoToSwim, chkGoToTheCinema;
	
	JRadioButton radMale, radFemale;
	ButtonGroup groupGender;
	
	public BorderJTextAreaCheckBoxRadioUI(String title)
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
		
		JPanel pnHobbiesAndGender=new JPanel();
		
		//pnHobbiesAndGender.setLayout(new BoxLayout(pnHobbiesAndGender, BoxLayout.X_AXIS));
		pnHobbiesAndGender.setLayout(new GridLayout(1,2));
		
		JPanel pnHobbies=new JPanel();	
		pnHobbies.setPreferredSize(new Dimension(200,100));
		Border borderHobbies=BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderHobbies=new TitledBorder(borderHobbies,"Hobbies");
		pnHobbies.setBorder(titleBorderHobbies);
		
		pnHobbies.setLayout(new BoxLayout(pnHobbies, BoxLayout.Y_AXIS));
		chkGoToSwim=new JCheckBox("Go to swim");
		chkGoToTheCinema=new JCheckBox("Go to the cinema");
		pnHobbies.add(chkGoToSwim);
		pnHobbies.add(chkGoToTheCinema);
		pnHobbiesAndGender.add(pnHobbies);
		
		JPanel pnGender=new JPanel();
		pnGender.setPreferredSize(new Dimension(200,100));
		Border borderGender=BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderGender=new TitledBorder(borderGender,"Gender");
		pnGender.setBorder(titleBorderGender);
		
		pnGender.setLayout(new BoxLayout(pnGender,BoxLayout.Y_AXIS));
		radMale=new JRadioButton("Male");
		radFemale=new JRadioButton("Female");
		groupGender=new ButtonGroup();
		groupGender.add(radMale);
		groupGender.add(radFemale);
		pnGender.add(radMale);
		pnGender.add(radFemale);
		pnHobbiesAndGender.add(pnGender);
		pnMain.add(pnHobbiesAndGender);
		
		
		
		JPanel pnOK=new JPanel();
		pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOK=new Button("OK");
		pnOK.add(btnOK);
		pnMain.add(pnOK);
		
		lblAddress.setPreferredSize(lblName.getPreferredSize());
		
	}
	public void addEvents()
	{
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getInfoHandling();
			}
		});
	}
	protected void getInfoHandling() {
		String msg=txtName.getText()+"\n";
		msg+=txtAddress.getText()+"\n";
		
		String hobbies="";
		if(chkGoToSwim.isSelected())
			hobbies+=chkGoToSwim.getText()+"\n";
		if(chkGoToTheCinema.isSelected())
			hobbies+=chkGoToTheCinema.getText();
		msg+=hobbies+"\n";
		String gender="";
		if(radMale.isSelected())
			gender=radMale.getText();
		else
			gender=radFemale.getText();
		msg+=gender;
		JOptionPane.showMessageDialog(null, msg);
	}
	public void showWindow()
	{
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
