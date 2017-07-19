package home.edu.vn.ui;

import home.edu.vn.model.Customer;
import home.edu.vn.model.CustomerGroup;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class CustomerUI extends JFrame {
	
	DefaultMutableTreeNode root=null;
	JTree treeGroup;
	
	DefaultTableModel dtm;
	JTable tblCus;
	
	JTextField txtId,txtName,txtPhone,txtEmail;
	JButton btnSave,btnDelete;
	
	ArrayList<CustomerGroup> lstGroup;
	ArrayList<Customer> lstCus;
	
	CustomerGroup groupSelected=null;
	
	
	public CustomerUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		fakeData();
	}

	private void addEvents() {
		treeGroup.addMouseListener(new MouseListener() {
			
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
				DefaultMutableTreeNode nodeSelected=(DefaultMutableTreeNode) 
						treeGroup.getLastSelectedPathComponent();
				if(nodeSelected!=null && nodeSelected.getLevel()==1)
				{
					groupSelected=(CustomerGroup) nodeSelected.getUserObject();
					displayListOfCustomerByGroup();
				}
			}
		});
		tblCus.addMouseListener(new MouseListener() {
			
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
				int rowSelected=tblCus.getSelectedRow();
				if(rowSelected==-1)return;
				String id=tblCus.getValueAt(rowSelected, 0)+"";
				String name=tblCus.getValueAt(rowSelected, 1)+"";
				String phone=tblCus.getValueAt(rowSelected, 2)+"";
				String email=tblCus.getValueAt(rowSelected, 3)+"";
				txtId.setText(id);
				txtName.setText(name);
				txtPhone.setText(phone);
				txtEmail.setText(email);
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Customer cus=new Customer(
						txtId.getText(),
						txtName.getText(),
						txtPhone.getText(),
						txtEmail.getText());
				groupSelected.addCustomer(cus);
			}
		});
	}

	protected void displayListOfCustomerByGroup() {
		dtm.setRowCount(0);
		for(Customer cus: groupSelected.getCustomers())
		{
			Vector<String>vec=new Vector<>();
			vec.add(cus.getId());
			vec.add(cus.getName());
			vec.add(cus.getPhone());
			vec.add(cus.getEmail());
			dtm.addRow(vec);
			
		}
	}

	private void addControls() {
		Container con=getContentPane();
		JPanel pnLeft=new JPanel();
		pnLeft.setPreferredSize(new Dimension(300,0));
		JPanel pnRight=new JPanel();
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		con.setLayout(new BorderLayout());
		con.add(sp,BorderLayout.CENTER);
		
		pnRight.setLayout(new BorderLayout());
		JPanel pnTopOfRight=new JPanel();
		pnTopOfRight.setPreferredSize(new Dimension(0,350));
		JPanel pnBottomOfRight=new JPanel();
		JSplitPane spRight=new JSplitPane(
				JSplitPane.VERTICAL_SPLIT,pnTopOfRight,pnBottomOfRight);
		pnRight.add(spRight,BorderLayout.CENTER);
		
		pnLeft.setLayout(new BorderLayout());
		root=new DefaultMutableTreeNode("Company at Home");
		treeGroup=new JTree(root);
		JScrollPane scTree=new JScrollPane(treeGroup,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scTree,BorderLayout.CENTER);
		
		pnTopOfRight.setLayout(new BorderLayout());
		dtm=new DefaultTableModel();
		dtm.addColumn("Customer Id");
		dtm.addColumn("Customer Name");
		dtm.addColumn("Customer Phone");
		dtm.addColumn("Customer Email");
		tblCus=new JTable(dtm);
		JScrollPane scTable=new JScrollPane(tblCus,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTable,BorderLayout.CENTER);
		
		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));
		JPanel pnId=new JPanel();
		pnId.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblId=new JLabel("Customer Id:");
		txtId=new JTextField(20);
		pnId.add(lblId);
		pnId.add(txtId);
		pnBottomOfRight.add(pnId);
		
		JPanel pnName=new JPanel();
		pnName.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName=new JLabel("Customer Name:");
		txtName=new JTextField(20);
		pnName.add(lblName);
		pnName.add(txtName);
		pnBottomOfRight.add(pnName);
		
		JPanel pnPhone=new JPanel();
		pnPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhone=new JLabel("Customer Phone:");
		txtPhone=new JTextField(20);
		pnPhone.add(lblPhone);
		pnPhone.add(txtPhone);
		pnBottomOfRight.add(pnPhone);
		
		JPanel pnEmail=new JPanel();
		pnEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail=new JLabel("Customer Email:");
		txtEmail=new JTextField(20);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnBottomOfRight.add(pnEmail);
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnSave=new JButton("Save Customer");
		btnDelete=new JButton("Delete Customer");
		pnButton.add(btnSave);
		pnButton.add(btnDelete);
		pnBottomOfRight.add(pnButton);
		
		lblId.setPreferredSize(lblPhone.getPreferredSize());
		lblName.setPreferredSize(lblPhone.getPreferredSize());
		lblEmail.setPreferredSize(lblPhone.getPreferredSize());
	}
	public void fakeData()
	{
		lstGroup=new ArrayList<CustomerGroup>();
		CustomerGroup vip=new CustomerGroup("grp1","VIP Customer");
		CustomerGroup potential=new CustomerGroup("grp2","Potential Customer");
		CustomerGroup prissy=new CustomerGroup("grp3","Prissy Customer");
		lstGroup.add(vip);
		lstGroup.add(potential);
		lstGroup.add(prissy);
		
		vip.getCustomers().add(new Customer("cus1","An","0981234567","an@gmail.com"));
		vip.getCustomers().add(new Customer("cus2","Bình","0971234567","binh@gmail.com"));
		vip.getCustomers().add(new Customer("cus3","Giải","0951234567","giai@gmail.com"));
		vip.getCustomers().add(new Customer("cus4","Thoát","0961234567","thoat@gmail.com"));
		
		for(CustomerGroup group: lstGroup)
		{
			DefaultMutableTreeNode nodeGroup=new DefaultMutableTreeNode(group);
			root.add(nodeGroup);	
			for(Customer cus:group.getCustomers())
			{
				DefaultMutableTreeNode nodeCus=new DefaultMutableTreeNode(cus);
				nodeGroup.add(nodeCus);
			}
		}
		
		treeGroup.expandRow(0);
	}
	public void showWindow()
	{
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
