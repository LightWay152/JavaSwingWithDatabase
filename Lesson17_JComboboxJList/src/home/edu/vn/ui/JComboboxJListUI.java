package home.edu.vn.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JComboboxJListUI extends JFrame{
	JComboBox cboNumber;
	JList listNumber;
	JButton btnOK;
	public JComboboxJListUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con=getContentPane();
		con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
		JPanel pnCombo=new JPanel();
		pnCombo.setLayout(new FlowLayout());
		JLabel lblChooseNumber=new JLabel("Chọn số:");
		pnCombo.add(lblChooseNumber);
		cboNumber=new JComboBox();
		Random rd=new Random();
		for(int i=0;i<100;i++)
		{
			int x=rd.nextInt(500);
			cboNumber.addItem(x);
		}
		pnCombo.add(cboNumber);
		con.add(pnCombo);
		
		JPanel pnList=new JPanel();
		pnList.setLayout(new FlowLayout());
		JLabel lblChooseNumber2=new JLabel("Chọn số 2");
		listNumber=new JList();
		Vector<Integer>vec=new Vector();
		for(int i=0;i<100;i++)
		{
			int x=rd.nextInt(500);
			vec.add(x);
		}
		listNumber.setListData(vec);
		pnList.add(lblChooseNumber2);
		
		JScrollPane scList=new JScrollPane(listNumber,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnList.add(scList);
		con.add(pnList);
		
		JPanel pnOK=new JPanel();
		pnOK.setLayout(new FlowLayout());
		
		btnOK=new JButton("OK");
		pnOK.add(btnOK);
		con.add(pnOK);
	}
	public void addEvents()
	{
		cboNumber.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int pos=cboNumber.getSelectedIndex();
				if(pos!=-1)
				{
					JOptionPane.showMessageDialog(null, 
							"Vị trí chọn="+pos+" giá trị ="+cboNumber.getSelectedItem());
				}
			}
		});
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				seeValueOfListHandling();
			}
		});
	}
	protected void seeValueOfListHandling() {
		Object obj=listNumber.getSelectedValue();
		int pos=listNumber.getSelectedIndex();
		JOptionPane.showMessageDialog(null, "LIST: selected position ="+pos+";Value="+obj);
	}
	public void showWindow()
	{
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
