package home.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class LearnJOptionPane_JFileChooser extends JFrame {
	
	JMenuBar mnuBar;
	JMenu mnuFile;
	JMenuItem mnuFileSave;
	JMenuItem mnuFileOpen;
	JMenuItem mnuFileExit;
	
	JTextArea txtData;
	
	JFileChooser chooser;
	
	
	public LearnJOptionPane_JFileChooser(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		mnuFileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exitProgramHandling();
			}
		});
		mnuFileOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFileHandling();
			}
		});
		mnuFileSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveFileHandling();
			}
		});
	}

	protected void saveFileHandling() {
		
		if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			String data=txtData.getText();
			try
			{
				FileOutputStream fos=new FileOutputStream(chooser.getSelectedFile());
				OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
				osw.write(data);
				osw.close();
				fos.close();
				JOptionPane.showMessageDialog(null, "Lưu file thành công");
			}
			catch(Exception ex)
			{
				
			}
		}
	}

	protected void openFileHandling() {
		
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			try{
				File seletedFile=chooser.getSelectedFile();
				FileInputStream fis=new FileInputStream(seletedFile);
				InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				String line=br.readLine();
				StringBuilder builder=new StringBuilder();
				while(line!=null)
				{
					builder.append(line);
					line=br.readLine();
				}
				br.close();
				txtData.setText(builder.toString());
			}
			catch(Exception e)
			{
				
			}
		}
	}

	protected void exitProgramHandling() {
		int ret=JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn thoát phần mềm này không?",
				"Xác nhận thoát",
				JOptionPane.YES_NO_OPTION);
		if(ret==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}

	private void addControls() {
		setupMenuBar();
		
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		txtData=new JTextArea(50,50);
		txtData.setLineWrap(true);
		txtData.setWrapStyleWord(true);
		JScrollPane sc=new JScrollPane(
				txtData,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(sc,BorderLayout.CENTER);
		
		chooser=new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Tập tin.txt";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".txt");
			}
		});
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Word 2003,2007,2010,2013";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".doc")||f.getAbsolutePath().endsWith(".docx");
			}
		});
	}
	private void setupMenuBar() {
		mnuBar=new JMenuBar();
		setJMenuBar(mnuBar);
		mnuFile=new JMenu("Hệ thống");
		mnuBar.add(mnuFile);
		mnuFileSave=new JMenuItem("Lưu tập tin");
		mnuFileOpen=new JMenuItem("Mở tập tin");
		mnuFileExit=new JMenuItem("Thoát phần mềm");
		mnuFile.add(mnuFileSave);
		mnuFile.add(mnuFileOpen);
		mnuFile.addSeparator();
		mnuFile.add(mnuFileExit);
	}

	public void showWindow()
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
