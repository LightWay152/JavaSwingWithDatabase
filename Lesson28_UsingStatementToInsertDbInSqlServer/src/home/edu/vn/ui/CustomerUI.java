package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerUI extends JFrame{

	DefaultTableModel dtmCustomer;
	JTable tblCustomer;
	JButton btnFirst,btnLast,btnNext,btnPrevious;
	
	JTextArea txtInfo;

	Connection conn=null;
	Statement statement;
	ResultSet result=null;
	
	int position=0;
	
	JTextField txtId,txtName,txtYob;
	JButton btnSave;

	public CustomerUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		connectDatabase();
		displayAllCustomer();
	}

	private void displayAllCustomer() {
		try
		{
			String sql="select * from Customer";
			result=statement.executeQuery(sql);
			dtmCustomer.setRowCount(0);
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			while(result.next())//trong khi coÌ€n dÆ°Ìƒ liÃªÌ£u Ä‘ÃªÌ‰ Ä‘oÌ£c
			{
				String id=result.getString("CustomerID");
				String name=result.getString("CustomerName");
				Date yob=result.getDate("YOB");
				Vector<Object>vec=new Vector<Object>();
				vec.add(id);
				vec.add(name);
				vec.add(sdf.format(yob));
				dtmCustomer.addRow(vec);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void connectDatabase() {
		String strServer="DESKTOP-UBC0EDN\\SQLEXPRESS";
		String strDatabase="dbCustomer";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl="jdbc:sqlserver://"+strServer+":1433;databaseName="+strDatabase+";integratedSecurity=true;";
			conn=DriverManager.getConnection(connectionUrl);
			//statement=conn.createStatement();//chiÌ‰ di chuyÃªÌ‰n tÆ¡Ì�i maÌ€ thÃ´i (khÃ´ng quay lui, khÃ´ng di chuyÃªÌ‰n tÆ¡Ì�i doÌ€ng bÃ¢Ì�t kyÌ€)
			statement=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void addEvents() {
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					result.last();
					txtInfo.setText(result.getString(2));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					result.first();
					txtInfo.setText(result.getString(2));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					position++;
					if(result.isLast()==true)
						position=1;
					result.absolute(position);
					txtInfo.setText(result.getString(2));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					position--;
					if(result.isFirst()==true)
						position=1;
					result.absolute(position);
					txtInfo.setText(result.getString(2));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveCustomerHandling();
			}
		});
	}

	protected void saveCustomerHandling() {
		try
		{
			String sql="insert into Customer "
					+ "values('"+txtId.getText()+"','"+txtName.getText()+"','"+txtYob.getText()+"','cusGroup1')";
			int x=statement.executeUpdate(sql);
			if(x>0)
			{
				displayAllCustomer();
			}
		}
		catch(Exception ex)
		{	
			ex.printStackTrace();
		}
	}

	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BorderLayout());
		dtmCustomer=new DefaultTableModel();
		dtmCustomer.addColumn("Customer Id");
		dtmCustomer.addColumn("Customer Name");
		dtmCustomer.addColumn("YOB");
		tblCustomer=new JTable(dtmCustomer);
		JScrollPane scTable=new JScrollPane(
				tblCustomer,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnMain.add(scTable,BorderLayout.CENTER);
		con.add(pnMain,BorderLayout.CENTER);
		JPanel pnNorth=new JPanel();
		pnNorth.setLayout(new BorderLayout());
		
		pnMain.add(pnNorth,BorderLayout.NORTH);
		btnFirst=new JButton("|<");
		btnPrevious=new JButton("<<");
		btnNext=new JButton(">>");
		btnLast=new JButton(">|");
		JPanel pnNorthOfNorth=new JPanel();
		pnNorthOfNorth.add(btnFirst);
		pnNorthOfNorth.add(btnPrevious);
		pnNorthOfNorth.add(btnNext);
		pnNorthOfNorth.add(btnLast);
		pnNorth.add(pnNorthOfNorth,BorderLayout.NORTH);
		
		txtInfo=new JTextArea(5,30);
		JScrollPane scInfo=new JScrollPane(
				txtInfo,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnNorth.add(scInfo,BorderLayout.CENTER);
		
		JPanel pnDetailInfo=new JPanel();
		pnDetailInfo.setLayout(new BoxLayout(pnDetailInfo, BoxLayout.Y_AXIS));
		pnMain.add(pnDetailInfo,BorderLayout.SOUTH);
		
		JPanel pnId=new JPanel();
		pnId.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblId=new JLabel("Id:");
		txtId=new JTextField(20);
		pnId.add(lblId);
		pnId.add(txtId);
		pnDetailInfo.add(pnId);
		
		JPanel pnName=new JPanel();
		pnName.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName=new JLabel("Name:");
		txtName=new JTextField(20);
		pnName.add(lblName);
		pnName.add(txtName);
		pnDetailInfo.add(pnName);
		
		JPanel pnYob=new JPanel();
		pnYob.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblYob=new JLabel("YOB:");
		txtYob=new JTextField(20);
		pnYob.add(lblYob);
		pnYob.add(txtYob);
		pnDetailInfo.add(pnYob);
		
		JPanel pnDetailButton=new JPanel();
		pnDetailButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnSave=new JButton("Save");
		pnDetailButton.add(btnSave);
		pnDetailInfo.add(pnDetailButton);
		
		lblId.setPreferredSize(lblName.getPreferredSize());
		lblYob.setPreferredSize(lblName.getPreferredSize());
	}
	public void showWindow()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
