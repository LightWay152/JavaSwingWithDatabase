package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class LearnJMenuContextMenuJToolBar extends JFrame {
	
	JMenuBar mnuBar;//nơi để đựng (chứa) các JMenu
	JMenu mnuFile;
	JMenu mnuEdit;
	JMenu mnuHelp;
	JMenuItem mnuFileNew;
	JMenuItem mnuFileOpen;
	JMenuItem mnuFileExit;
	
	JMenuItem mnuEditCopy;
	JMenuItem mnuEditPaste;
	JMenuItem mnuEditDelete;
	
	JMenuItem mnuHelpGui;
	JMenuItem mnuHelpAbout;
	
	JButton btn1,btn2;
	
	JMenuItem mnuPopupMauXanh,mnuPopupMauDo;
	
	JButton btnLastedChoose=null;
	
	JToolBar tooBar;
	JButton btnLenh1, btnLenh2;
	JCheckBox chk1,chk2;
	
	public LearnJMenuContextMenuJToolBar(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		mnuFileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		mnuFileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Bạn vừa gõ Ctrl+N");
			}
		});
		btnLenh1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Bạn chọn lệnh 1 trên Toolbar");
			}
		});
	}

	private void addControls() {
		mnuBar=new JMenuBar();
		setJMenuBar(mnuBar);
		mnuFile=new JMenu("File");
		mnuBar.add(mnuFile);
		mnuEdit=new JMenu("Edit");
		mnuBar.add(mnuEdit);
		mnuHelp=new JMenu("Help");
		mnuBar.add(mnuHelp);
		mnuBar.add(mnuHelp);
		
		mnuFileNew=new JMenuItem("New");
		
		mnuFileNew.setAccelerator(KeyStroke.getKeyStroke('N', 
				Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		
		mnuFile.add(mnuFileNew);
		mnuFileOpen=new JMenuItem("Open");
		mnuFile.add(mnuFileOpen);
		mnuFile.addSeparator();
		mnuFileExit=new JMenuItem("Exit");
		mnuFileExit.setIcon(new ImageIcon("images/exit.png"));
		mnuFile.add(mnuFileExit);
		
		mnuEditCopy=new JMenuItem("Copy");
		mnuEdit.add(mnuEditCopy);
		mnuEditPaste=new JMenuItem("Paste");
		mnuEdit.add(mnuEditPaste);
		mnuEdit.addSeparator();
		mnuEditDelete=new JMenuItem("Delete");
		mnuEdit.add(mnuEditDelete);
		
		mnuHelpGui=new JMenuItem("Guide");
		mnuHelp.add(mnuHelpGui);
		mnuHelp.addSeparator();
		mnuHelpAbout=new JMenuItem("About");
		mnuHelp.add(mnuHelpAbout);
		
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		tooBar=new JToolBar();
		btnLenh1=new JButton("Lệnh 1");
		btnLenh2=new JButton("Lệnh 2");
		tooBar.add(btnLenh1);
		tooBar.add(btnLenh2);
		chk1=new JCheckBox("Tự động lưu dữ liệu sau 10 phút");
		tooBar.add(chk1);
		con.add(tooBar,BorderLayout.NORTH);
		
		
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new FlowLayout());
		
		btn1=new JButton("Button 1");
		pnMain.add(btn1);
		btn2=new JButton("Button 2");
		pnMain.add(btn2);
		
		con.add(pnMain,BorderLayout.CENTER);
		
		btn1.addMouseListener(new PopClickListener());
		btn2.addMouseListener(new PopClickListener());
		
	}
	class PopUpDemo extends JPopupMenu{
		public PopUpDemo(){
			mnuPopupMauDo=new JMenuItem("Tô màu đỏ");
			add(mnuPopupMauDo);
			mnuPopupMauXanh=new JMenuItem("Tô màu xanh");
			add(mnuPopupMauXanh);
			
			mnuPopupMauDo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(btnLastedChoose!=null)
						btnLastedChoose.setBackground(Color.RED);
				}
			});
			mnuPopupMauXanh.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(btnLastedChoose!=null)
						btnLastedChoose.setBackground(Color.BLUE);
				}
			});
		}
	}
	class PopClickListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			if(e.isPopupTrigger())
				doPop(e);
		}
		public void mouseReleased(MouseEvent e){
			if(e.isPopupTrigger())
				doPop(e);
		}
		private void doPop(MouseEvent e){
			PopUpDemo menu=new PopUpDemo();
			btnLastedChoose=(JButton) e.getComponent();
			menu.show(e.getComponent(),e.getX(),e.getY());
		}
	}
	public void showWindow()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
