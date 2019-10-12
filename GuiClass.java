package smellProject;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.util.*;
public class GuiClass implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JButton btnDetectSmell;
	private String app = null;
	private String testFilePath;
	ArrayList<String> testclasses = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClass window = new GuiClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 460, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(163, 196, 97, 25);
		
		btnSelect.addActionListener(this);
	    
		frame.getContentPane().add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.out.println("anika");
				
	            JFileChooser jfc = new JFileChooser();
	            jfc.setCurrentDirectory(new java.io.File("F:\\6th_semester\\testing & quality assurance\\cs3-final-project-master\\cs3-final-project-master\\testFinalProject"));
	    		jfc.setMultiSelectionEnabled(true);
	            FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java");
	            jfc.setFileFilter(filter);
	            int returnValue = jfc.showOpenDialog(null);
	    		
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	                System.out.println("getCurrentDirectory(): "+ jfc.getCurrentDirectory());
	                File[] files = jfc.getSelectedFiles();
	                for (File f: files) {
	                	String tc=jfc.getCurrentDirectory()+"\\"+f.getName();
	                	testclasses.add(tc);
	                	System.out.println(tc);
	                }
	                System.out.println("getSelectedFile() : "+ jfc.getSelectedFile());
	                app=jfc.getSelectedFile().toString();
	                testFilePath=jfc.getSelectedFile().toString();
	                
	            } else {
	                System.out.println("No Selection ");
	            }
			}
			     
	    } );
		
		frame.getContentPane().add(btnSelect);
		
		textField = new JTextField();
		textField.setBounds(36, 129, 356, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGeneralFixture = new JLabel("General Fixture");
		lblGeneralFixture.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblGeneralFixture.setBounds(150, 41, 196, 43);
		frame.getContentPane().add(lblGeneralFixture);
		
		btnDetectSmell = new JButton("detect smell");
		btnDetectSmell.setBounds(126, 263, 184, 25);
		frame.getContentPane().add(btnDetectSmell);
		
		btnDetectSmell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.out.println("popo");
				Initialization init= new Initialization(app, testFilePath);
				init.createTestFile();
				try {
					init.writeResult();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
