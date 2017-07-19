package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LearnJTableUI extends JFrame{
	
	DefaultTableModel dtm;
	JTable tblStudent;
	
	JButton btnAdd, btnDelete;
	
	public LearnJTableUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	private void addControls() {
		Container con=getContentPane();
		JPanel pnLeft=new JPanel();
		JPanel pnRight=new JPanel();
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		con.add(sp);
		
		dtm=new DefaultTableModel();
		dtm.addColumn("Id");
		dtm.addColumn("Name");
		dtm.addColumn("Address");
		
		//thử đưa 1 vài dòng dữ liệu vào:
		String row1[]={"SV1","Nguyễn Văn Tèo","Hố Nai"};
		dtm.addRow(row1);
		String row2[]={"SV2","Trần Thị Tý","Đầm Dơi"};
		dtm.addRow(row2);
		
		Vector<String>vec3=new Vector<String>();
		vec3.add("sv3");
		vec3.add("Hồ Văn Đồ");
		vec3.add("Lạng Sơn");
		dtm.addRow(vec3);
		
		
		
		tblStudent=new JTable(dtm);
		JScrollPane scTable=new JScrollPane(
				tblStudent,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.setLayout(new BorderLayout());
		pnLeft.add(scTable,BorderLayout.CENTER);
		pnLeft.setPreferredSize(new Dimension(300,0));
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnAdd=new JButton("Add");
		btnDelete=new JButton("Delete");
		pnButton.add(btnAdd);
		pnButton.add(btnDelete);
		pnLeft.add(pnButton,BorderLayout.SOUTH);
	}
	public void addEvents()
	{
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Vector<String>vec=new Vector<String>();
				vec.add("Id XYZ");
				vec.add("Name XYZ");
				vec.add("Address XYZ");
				dtm.addRow(vec);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row=tblStudent.getSelectedRow();
				if(row==-1)return;
				
				dtm.removeRow(row);
			}
		});
		tblStudent.addMouseListener(new MouseListener() {
			
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
				int row=tblStudent.getSelectedRow();
				if(row==-1)return;
				String id=tblStudent.getValueAt(row, 0)+"";
				String name=tblStudent.getValueAt(row, 1)+"";
				String address=tblStudent.getValueAt(row, 2)+"";
				JOptionPane.showMessageDialog(null, "Id="+id+"\nName="+name+"\nAddress="+address);
			}
		});
	}
	public void showWindow()
	{
		this.setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
