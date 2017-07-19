package home.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SuperlativeEquation extends JFrame {
	JTextField txtCoefficientA, txtCoefficientB;
	JButton btnSolution, btnExit, btnHelp;
	JTextField txtResult;
	
	ActionListener eventSolution=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			superlativeEquationHandling();
		}
	};
	public SuperlativeEquation(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	protected void superlativeEquationHandling() {
		String coeA=txtCoefficientA.getText();
		String coeB=txtCoefficientB.getText();
		double a=Double.parseDouble(coeA);
		double b=Double.parseDouble(coeB);
		if(a==0 && b==0)
		{
			//assign a value to JTextField
			txtResult.setText("Many solutions");
		}
		else if(a==0 && b!=0)
		{
			txtResult.setText("No solutions");
		}
		else
		{
			double x=-b/a;
			txtResult.setText("x="+x);
		}	
	}
	public void addEvents()
	{
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSolution.addActionListener(eventSolution);
		btnHelp.addActionListener(new HelpEvent());
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnTitle=new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTitle=new JLabel("Superlative Equation");
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle=new Font("arial",Font.BOLD,20);
		lblTitle.setFont(fontTitle);
		
		JPanel pnCoefficientA=new JPanel();
		pnCoefficientA.setLayout(new FlowLayout());
		JLabel lblCoefficientA=new JLabel("Coefficient A:");
		txtCoefficientA=new JTextField(15);
		pnCoefficientA.add(lblCoefficientA);
		pnCoefficientA.add(txtCoefficientA);
		pnMain.add(pnCoefficientA);
		
		JPanel pnCoefficientB=new JPanel();
		pnCoefficientB.setLayout(new FlowLayout());
		JLabel lblCoefficientB=new JLabel("Coefficient B:");
		txtCoefficientB=new JTextField(15);
		pnCoefficientB.add(lblCoefficientB);
		pnCoefficientB.add(txtCoefficientB);
		pnMain.add(pnCoefficientB);
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnSolution=new JButton("Solution");
		btnExit=new JButton("Exit");
		btnExit.setIcon(new ImageIcon("Images/exit.png"));	
		btnHelp=new JButton("Help");
		pnButton.add(btnSolution);
		pnButton.add(btnExit);
		pnButton.add(btnHelp);
		pnMain.add(pnButton);
		
		
		JPanel pnResult=new JPanel();
		pnResult.setLayout(new FlowLayout());
		JLabel lblResult=new JLabel("Result:");
		txtResult=new JTextField(15);
		pnResult.add(lblResult);
		pnResult.add(txtResult);
		pnMain.add(pnResult);
		
	}
	class HelpEvent implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "Please contact to email: dao.nbm1502@gmail.com");
		}
		
	}
	public void showWindow()
	{
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//exit when click on X button
		this.setLocationRelativeTo(null);//window located at center of desktop's screen
		this.setVisible(true);//display window on desktop's screen
	}
	
}
