package home.edu.vn.ui;

import home.edu.vn.Department;
import home.edu.vn.Staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class StaffManagementUI extends JFrame {
	
	JComboBox<Department>cboDepartment;
	JList<Staff>listStaff;
	JTextField txtCode, txtName, txtSWD, txtYOB;//SWD: start work day
	JButton btnSave, btnDelete, btnExit;
	
	ArrayList<Department>listDepartment;
	ArrayList<Staff>listStaffWithDepartment;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	Department depSelected=null;
	Staff stfSelected=null;
	
	public StaffManagementUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		fakeData();
	}
	public void addControls()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		JPanel pnDepartment=new JPanel();
		pnDepartment.setLayout(new FlowLayout());
		pnMain.add(pnDepartment);
		JLabel lblDepartment=new JLabel("Choose department:");
		cboDepartment=new JComboBox<Department>();
		cboDepartment.setPreferredSize(new Dimension(200, 25));
		pnDepartment.add(lblDepartment);
		pnDepartment.add(cboDepartment);
		
		JPanel pnListAndDetail=new JPanel();
		pnListAndDetail.setLayout(new GridLayout(1,2));
		pnMain.add(pnListAndDetail);
		JPanel pnList=new JPanel();
		pnList.setLayout(new FlowLayout());
		
		Border borderList=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderList=new TitledBorder(borderList,"List");
		titleBorderList.setTitleJustification(TitledBorder.CENTER);
		titleBorderList.setTitleColor(Color.RED);
		pnList.setBorder(titleBorderList);
		
		listStaff=new JList<Staff>();
		JScrollPane sc=new JScrollPane(listStaff,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnList.add(sc,BorderLayout.CENTER);
		pnListAndDetail.add(pnList);
		
		JPanel pnDetail=new JPanel();
		pnDetail.setLayout(new BoxLayout(pnDetail, BoxLayout.Y_AXIS));
		
		Border borderDetail=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderDetail=new TitledBorder(borderList,"Detail Information");
		titleBorderDetail.setTitleJustification(TitledBorder.CENTER);
		titleBorderDetail.setTitleColor(Color.RED);
		pnDetail.setBorder(titleBorderDetail);
		
		pnListAndDetail.add(pnDetail);
		
		JPanel pnCode=new JPanel();
		pnCode.setLayout(new FlowLayout());
		JLabel lblCode=new JLabel("Code:");
		txtCode=new JTextField(15);
		pnCode.add(lblCode);
		pnCode.add(txtCode);
		pnDetail.add(pnCode);
		
		JPanel pnName=new JPanel();
		pnName.setLayout(new FlowLayout());
		JLabel lblName=new JLabel("Name:");
		txtName=new JTextField(15);
		pnName.add(lblName);
		pnName.add(txtName);
		pnDetail.add(pnName);
		
		JPanel pnSWD=new JPanel();//SWD: start work day
		pnSWD.setLayout(new FlowLayout());
		JLabel lblSWD=new JLabel("SWD:");
		txtSWD=new JTextField(15);
		pnSWD.add(lblSWD);
		pnSWD.add(txtSWD);
		pnDetail.add(pnSWD);
		
		JPanel pnYOB=new JPanel();
		pnYOB.setLayout(new FlowLayout());
		JLabel lblYOB=new JLabel("YOB:");
		txtYOB=new JTextField(15);
		pnYOB.add(lblYOB);
		pnYOB.add(txtYOB);
		pnDetail.add(pnYOB);
		
		JPanel pnButton=new JPanel();
		
		Border borderButton=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderButton=new TitledBorder(borderList,"Choose Option");
		titleBorderButton.setTitleJustification(TitledBorder.CENTER);
		titleBorderButton.setTitleColor(Color.RED);
		pnButton.setBorder(titleBorderButton);
		
		
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnSave=new JButton("Save");
		btnDelete=new JButton("Delete");
		btnExit=new JButton("Exit");
		
		pnButton.add(btnSave);
		pnButton.add(btnDelete);
		pnButton.add(btnExit);
		pnMain.add(pnButton);
			
		lblCode.setPreferredSize(lblName.getPreferredSize());
		lblSWD.setPreferredSize(lblName.getPreferredSize());
		lblYOB.setPreferredSize(lblName.getPreferredSize());
	}
	public void fakeData()
	{
		listDepartment=new ArrayList<Department>();
		
		Department depMeetingRoom=new Department();
		depMeetingRoom.setDepCode("Dep 01");
		depMeetingRoom.setDepName("Meeting Room Department");
		
		Department depBusiness=new Department();
		depBusiness.setDepCode("Dep 02");
		depBusiness.setDepName("Business Department");
		
		Department depAccounting=new Department();
		depAccounting.setDepCode("Dep 03");
		depAccounting.setDepName("Accounting Department");
		
		listDepartment.add(depMeetingRoom);
		listDepartment.add(depBusiness);
		listDepartment.add(depAccounting);
		
		depMeetingRoom.addStaff(new Staff("NV1","Nguyen Thi An",
						new Date(2016-1900,1,1),new Date(1990-1900,1,1)));
		
		depMeetingRoom.addStaff(new Staff("NV2","Tran Van Binh",
				new Date(2015-1900,1,1),new Date(1992-1900,1,1)));
		
		depBusiness.addStaff(new Staff("NV3","Ho Thi Giai",
				new Date(2013-1900,1,1),new Date(1989-1900,1,1)));
		
		depBusiness.addStaff(new Staff("NV4","Tran Dinh Thoat",
				new Date(2014-1900,1,1),new Date(1988-1900,1,1)));
		
		for(Department dep: listDepartment)
		{
			cboDepartment.addItem(dep);
		}
	}
	public void addEvents()
	{
		cboDepartment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(cboDepartment.getSelectedIndex()==-1)return;
				
				depSelected=(Department) cboDepartment.getSelectedItem();
				listStaff.setListData(depSelected.getStaffs());
			}
		});
		listStaff.addMouseListener(new MouseListener() {
			
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
				if(listStaff.getSelectedIndex()==-1)return;
				stfSelected=listStaff.getSelectedValue();
				txtCode.setText(stfSelected.getStfCode());
				txtName.setText(stfSelected.getStfName());
				txtYOB.setText(sdf.format(stfSelected.getYearOfBirth()));
				txtSWD.setText(sdf.format(stfSelected.getStartWorkDay()));
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				saveHandling();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				deleteHandling();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);;
			}
		});
	}
	protected void deleteHandling() {
		if(stfSelected!=null)
		{
			depSelected.getStaffs().remove(stfSelected);
			stfSelected=null;
			listStaff.setListData(depSelected.getStaffs());
		}
	}
	protected void saveHandling() {
		try{
			Staff stf=new Staff(
					txtCode.getText(),
					txtName.getText(),
					sdf.parse(txtSWD.getText()),
					sdf.parse(txtYOB.getText()));
			if(depSelected!=null)
			{
				depSelected.addStaff(stf);
				listStaff.setListData(depSelected.getStaffs());
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public void showWindow()
	{
		this.setSize(550,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
