package home.edu.vn.ui;

import home.edu.vn.model.DanhMuc;
import home.edu.vn.model.SanPham;
import home.edu.vn.service.DanhMucService;
import home.edu.vn.service.SanPhamService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Vector;

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
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLySanPhamUI extends JFrame {
	
	JList<DanhMuc>listDanhMuc;
	
	JButton btnThemMoiDanhMuc,btnChinhSuaDanhMuc,btnXoaDanhMuc;
	
	DefaultTableModel dtmSanPham;
	JTable tblSanPham;
	
	JComboBox<DanhMuc>cboDanhMuc;
	
	JTextField txtMasp,txtTensp,txtSoluong,txtDonGia;
	
	JButton btnTaoMoiSp,btnLuuSp,btnXoaSp;
	
	ArrayList<SanPham>dsSp;
	
	DanhMuc dmSelected=null;
	
	public QuanLySanPhamUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
		hienThiDanhMucLenList();
	}

	private void hienThiDanhMucLenList() {
		DanhMucService dmService=new DanhMucService();
		Vector<DanhMuc>vec=dmService.docToanBoDanhMuc();
		listDanhMuc.setListData(vec);
		cboDanhMuc.removeAllItems();
		for(DanhMuc dm: vec)
		{
			cboDanhMuc.addItem(dm);
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		listDanhMuc.addMouseListener(new MouseListener() {
			
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
				if(listDanhMuc.getSelectedValue()==null)return;
				dmSelected=listDanhMuc.getSelectedValue();
				SanPhamService spService=new SanPhamService();
				dsSp=
						spService.docSanPhamTheoDanhMuc(
								listDanhMuc.getSelectedValue().getMaDM());
				dtmSanPham.setRowCount(0);
				for(SanPham sp:dsSp)
				{
					Vector<Object>vec=new Vector<Object>();
					vec.add(sp.getMaSp());
					vec.add(sp.getTenSp());
					vec.add(sp.getSoLuong());
					vec.add(sp.getDonGia());
					dtmSanPham.addRow(vec);
				}
			}
		});
		tblSanPham.addMouseListener(new MouseListener() {
			
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
				int row=tblSanPham.getSelectedRow();
				if(row==-1)return;
				SanPham sp=dsSp.get(row);
				txtMasp.setText(sp.getMaSp());
				txtTensp.setText(sp.getTenSp());
				txtSoluong.setText(sp.getSoLuong()+"");
				txtDonGia.setText(sp.getDonGia()+"");	
			}
		});
		btnTaoMoiSp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtDonGia.setText("");
				txtMasp.setText("");
				txtSoluong.setText("");
				txtTensp.setText("");
				txtMasp.requestFocus();
			}
		});
		btnLuuSp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				xuLyLuuSanPham();
			}
		});
	}

	protected void xuLyLuuSanPham() {
		SanPham sp=new SanPham();
		sp.setMaDM(dmSelected.getMaDM());
		sp.setMaSp(txtMasp.getText());
		sp.setTenSp(txtTensp.getText());
		sp.setSoLuong(Integer.parseInt(txtSoluong.getText()));
		sp.setDonGia(Integer.parseInt(txtDonGia.getText()));
		SanPhamService spService=new SanPhamService();
		if(spService.luuSanPham(sp)>0)
		{
			JOptionPane.showMessageDialog(null, "Lưu SP thành công");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Lưu SP thất bại");
		}
	}

	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel pnLeft=new JPanel();
		pnLeft.setPreferredSize(new Dimension(300,0));
		JPanel pnRight=new JPanel();
		
		JSplitPane sp=new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				pnLeft,pnRight);
		sp.setOneTouchExpandable(true);
		con.add(sp,BorderLayout.CENTER);
		
		pnLeft.setLayout(new BorderLayout());
		listDanhMuc=new JList<DanhMuc>();
		JScrollPane scListDanhMuc=new JScrollPane(
				listDanhMuc,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scListDanhMuc,BorderLayout.CENTER);
		
		TitledBorder borderListDm=
				new TitledBorder(
						BorderFactory.createLineBorder(Color.RED),
						"Danh mục sản phẩm");
		listDanhMuc.setBorder(borderListDm);
		
		btnThemMoiDanhMuc=new JButton("Thêm DM");
		btnChinhSuaDanhMuc=new JButton("Cập nhật DM");
		btnXoaDanhMuc=new JButton("Xóa DM");
		JPanel pnButtonDanhMuc=new JPanel();
		pnButtonDanhMuc.add(btnThemMoiDanhMuc);
		pnButtonDanhMuc.add(btnChinhSuaDanhMuc);
		pnButtonDanhMuc.add(btnXoaDanhMuc);
		
		pnLeft.add(pnButtonDanhMuc,BorderLayout.SOUTH);
		
		pnRight.setLayout(new BorderLayout());
		JPanel pnTopOfRight=new JPanel();
		pnTopOfRight.setLayout(new BorderLayout());
		pnRight.add(pnTopOfRight,BorderLayout.CENTER);
		pnTopOfRight.setPreferredSize(new Dimension(0,300));
		
		dtmSanPham=new DefaultTableModel();
		dtmSanPham.addColumn("Mã SP");
		dtmSanPham.addColumn("Tên SP");
		dtmSanPham.addColumn("Số lượng");
		dtmSanPham.addColumn("Đơn giá");
		tblSanPham=new JTable(dtmSanPham);
		JScrollPane scTable=new JScrollPane(tblSanPham,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTable,BorderLayout.CENTER);
		
		JPanel pnBottomOfRight=new JPanel();
		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));
		pnRight.add(pnBottomOfRight,BorderLayout.SOUTH);
		
		JPanel pnDanhMuc=new JPanel();
		pnDanhMuc.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDanhMuc=new JLabel("Danh mục:");
		cboDanhMuc=new JComboBox<DanhMuc>();
		cboDanhMuc.setPreferredSize(new Dimension(350,30));
		pnDanhMuc.add(lblDanhMuc);
		pnDanhMuc.add(cboDanhMuc);
		pnBottomOfRight.add(pnDanhMuc);
		
		JPanel pnMaSp=new JPanel();
		pnMaSp.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMaSp=new JLabel("Mã SP:");
		txtMasp=new JTextField(30);
		pnMaSp.add(lblMaSp);
		pnMaSp.add(txtMasp);
		pnBottomOfRight.add(pnMaSp);
		
		JPanel pnTenSp=new JPanel();
		pnTenSp.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTenSp=new JLabel("Tên SP:");
		txtTensp=new JTextField(30);
		pnTenSp.add(lblTenSp);
		pnTenSp.add(txtTensp);
		pnBottomOfRight.add(pnTenSp);
		
		JPanel pnSoluong=new JPanel();
		pnSoluong.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSoluong=new JLabel("Số lượng:");
		txtSoluong=new JTextField(30);
		pnSoluong.add(lblSoluong);
		pnSoluong.add(txtSoluong);
		pnBottomOfRight.add(pnSoluong);
		
		JPanel pnDonGia=new JPanel();
		pnDonGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDonGia=new JLabel("Đơn giá:");
		txtDonGia=new JTextField(30);
		pnDonGia.add(lblDonGia);
		pnDonGia.add(txtDonGia);
		pnBottomOfRight.add(pnDonGia);
		
		JPanel pnButtonSanPham=new JPanel();
		pnButtonSanPham.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnTaoMoiSp=new JButton("Tạo mới");
		btnLuuSp=new JButton("Lưu sản phẩm");
		btnXoaSp=new JButton("Xóa sản phẩm");
		pnButtonSanPham.add(btnTaoMoiSp);
		pnButtonSanPham.add(btnLuuSp);
		pnButtonSanPham.add(btnXoaSp);
		pnBottomOfRight.add(pnButtonSanPham);
		
		lblMaSp.setPreferredSize(lblSoluong.getPreferredSize());
		lblTenSp.setPreferredSize(lblSoluong.getPreferredSize());
		lblDonGia.setPreferredSize(lblSoluong.getPreferredSize());
		
	}
	public void showWindow()
	{
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
