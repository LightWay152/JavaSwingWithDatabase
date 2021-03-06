package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TimKiemCDDVDUI extends JDialog {
	
	JTextField txtLoaiCD,txtNamXuatBan;
	JButton btnTim;
	
	DefaultTableModel dtmCd;
	JTable tblCd;
	
	Connection conn=null;
	PreparedStatement preStatement=null;
	ResultSet result=null;
	
	public TimKiemCDDVDUI(String title)
	{
		this.setTitle(title);
		addControls();
		addEvent();
		connectDB();
	}
	private void connectDB() {
		String strServer="DESKTOP-UBC0EDN\\SQLEXPRESS";
		String strDatabase="dbQuanLyCDDVD";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl="jdbc:sqlserver://"+strServer+":1433;databaseName="+strDatabase+";integratedSecurity=true;";
			conn=DriverManager.getConnection(connectionUrl);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void addEvent() {
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				xyLyTimKiem();
			}
		});
	}

	protected void xyLyTimKiem() {
		try
		{
			CallableStatement callableStatement=
					conn.prepareCall("{call LayDanhSachDiaTheoLoaiVaNamXuatBanBatKy(?,?)}");
			callableStatement.setString(1, txtLoaiCD.getText());
			callableStatement.setInt(2, Integer.parseInt(txtNamXuatBan.getText()));
			result=callableStatement.executeQuery();
			
			dtmCd.setRowCount(0);
			while(result.next())
			{
				Vector<Object> vec=new Vector<Object>();
				vec.add(result.getString("Ma"));
				vec.add(result.getString("TieuDe"));
				vec.add(result.getString("LoaiDia"));
				vec.add(result.getInt("NamXuatBan"));
				dtmCd.addRow(vec);
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

		dtmCd=new DefaultTableModel();
		dtmCd.addColumn("Mã ");
		dtmCd.addColumn("Tiêu đề");
		dtmCd.addColumn("Loại");
		dtmCd.addColumn("Năm XB");
		tblCd=new JTable(dtmCd);
		JScrollPane scTable=new JScrollPane(tblCd,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(scTable,BorderLayout.CENTER);
		
		JPanel pnTim=new JPanel();
		JLabel lblTim=new JLabel("Loại CD/DVD:");
		txtLoaiCD=new JTextField(10);
		btnTim=new JButton("Tìm");
		pnTim.add(lblTim);
		pnTim.add(txtLoaiCD);
		
		JLabel lblNxb=new JLabel("Năm XB:");
		txtNamXuatBan=new JTextField(10);
		pnTim.add(lblNxb);
		pnTim.add(txtNamXuatBan);
		
		pnTim.add(btnTim);
		con.add(pnTim,BorderLayout.NORTH);
	}
	public void showWindow()
	{
		this.setSize(500,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}
