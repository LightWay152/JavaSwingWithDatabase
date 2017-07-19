package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CDDVDUI extends JFrame {
	
	JTextField txtMa,txtTen,txtLoai,txtNamXuatBan;
	JButton btnLuu,btnXoa,btnTimKiem;
	
	DefaultTableModel dtmCd;
	JTable tblCd;
	
	Connection conn=null;
	PreparedStatement preStatement=null;
	ResultSet result=null;
	
	public CDDVDUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		connectDB();
		displayAllCDDVD();
	}

	private void displayAllCDDVD() {
		try
		{
			String sql="select * from CDDVDCollection";
			preStatement=conn.prepareStatement(sql);
			result=preStatement.executeQuery();
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

	private void addEvents() {
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TimKiemCDDVDUI ui=new TimKiemCDDVDUI("Tìm kiếm CD/DVD");
				ui.showWindow();
			}
		});
	}

	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnThongTin=new JPanel();
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		con.add(pnThongTin,BorderLayout.NORTH);
		
		JPanel pnMa=new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa=new JLabel("Mã:");
		txtMa=new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnThongTin.add(pnMa);
		
		JPanel pnTen=new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen=new JLabel("Tên:");
		txtTen=new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnThongTin.add(pnTen);
		
		JPanel pnLoai=new JPanel();
		pnLoai.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblLoai=new JLabel("Loại:");
		txtLoai=new JTextField(20);
		pnLoai.add(lblLoai);
		pnLoai.add(txtLoai);
		pnThongTin.add(pnLoai);
		
		JPanel pnNamXB=new JPanel();
		pnNamXB.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNamXB=new JLabel("Năm XB:");
		txtNamXuatBan=new JTextField(20);
		pnNamXB.add(lblNamXB);
		pnNamXB.add(txtNamXuatBan);
		pnThongTin.add(pnNamXB);
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnLuu=new JButton("Lưu");
		btnXoa=new JButton("Xóa");
		btnTimKiem=new JButton("Tìm Kiếm");
		pnButton.add(btnLuu);
		pnButton.add(btnXoa);
		pnButton.add(btnTimKiem);
		pnThongTin.add(pnButton);
		
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
		
		lblLoai.setPreferredSize(lblNamXB.getPreferredSize());
		lblMa.setPreferredSize(lblNamXB.getPreferredSize());
		lblTen.setPreferredSize(lblNamXB.getPreferredSize());
	}
	public void showWindow()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
