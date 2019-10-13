package smellProject;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
public class GuiClass implements ActionListener {

	private JFrame frame;
	private JButton btnDetectSmell;
	private String app = null;
	private String testFilePath;
	ArrayList<String> testclasses = new ArrayList<String>();
	private JTable table;
	public  String filePath="";
	JScrollPane scrollPane = new JScrollPane(table);
	
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
	public void dataFill() {
		
        File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setColumnIdentifiers(columnsName);
            
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
            // extratct data from lines
            // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            
            
        } catch (Exception ex) {
           System.out.println("prob");
        }
    
	
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 224));
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 1050, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnSelect = new JButton("Select file to test");
		btnSelect.setForeground(new Color(255, 255, 255));
		btnSelect.setBackground(new Color(47, 79, 79));
		btnSelect.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnSelect.setBounds(45, 130, 173, 36);
		
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
		
		JLabel lblGeneralFixture = new JLabel("General Fixture");
		lblGeneralFixture.setFont(new Font("Tempus Sans ITC", Font.BOLD, 44));
		lblGeneralFixture.setBounds(150, 41, 323, 43);
		frame.getContentPane().add(lblGeneralFixture);
		
		btnDetectSmell = new JButton("Detect smell");
		btnDetectSmell.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnDetectSmell.setForeground(new Color(240, 248, 255));
		btnDetectSmell.setBackground(new Color(95, 158, 160));
		btnDetectSmell.setBounds(438, 130, 157, 36);
		frame.getContentPane().add(btnDetectSmell);
		
		JButton btnNewButton = new JButton("Show output ");
		btnNewButton.setForeground(new Color(240, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataFill();
			}
		}
		);
		
		
		table = new JTable();
		table.setBackground(new Color(230, 230, 250));
		table.setBounds(12, 201, 1008, 429);
		//frame.add(new JScrollPane(table)); 
        //frame.pack(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
		frame.getContentPane().add(table);
		btnNewButton.setBounds(822, 130, 173, 36);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
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
				filePath=init.resultsWriter.outputFile;
				System.out.println(filePath);
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
