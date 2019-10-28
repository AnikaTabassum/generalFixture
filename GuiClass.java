package smellProject;
import java.awt.EventQueue;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
public class GuiClass implements ActionListener {

	private JFrame frame;
	private JButton btnDetectSmell;
	private String app = null;
	private String testFilePath=null;
	ArrayList<String> testclasses = new ArrayList<String>();
	private JTable table;
	public  String filePath="";
	public JPanel JPContainer = new JPanel();
	
	
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
            String firstLine = br.readLine().trim();
            //System.out.println(firstLine);
            String[] columnsName = firstLine.split(",");
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setColumnIdentifiers(columnsName);
            model.addRow(columnsName);

            Object[] tableLines = br.lines().toArray();

            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                int x=0;
                for (String c:dataRow) {
                	//System.out.println(c);
                	if (c.contains("+-+-+")) {
                		//System.out.println("x"+x+dataRow[x]);
                		
                		c=c.replace("+-+-+", ",");
                	}
                	
                	dataRow[x]=c;
                	//System.out.println("x"+x+dataRow[x]);
                	x++;
                }
                model.addRow(dataRow);
            }
            
            
        } catch (Exception ex) {
           System.out.println("prob");
        }
    
	
	}
	public File projectDir;
	public List <String >testWithFullPath= new ArrayList<String>();
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 224));
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 1200, 690);
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
				//System.out.println("anika");
				
	            JFileChooser jfc = new JFileChooser();
	            jfc.setCurrentDirectory(new java.io.File("F:\\6th_semester\\testing & quality assurance\\cs3-final-project-master\\cs3-final-project-master\\testFinalProject"));
	    		
	            jfc.setMultiSelectionEnabled(true);
	    		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            //FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java");
	            //jfc.setFileFilter(filter);
	            int returnValue = jfc.showOpenDialog(null);
	    		
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					
	                //System.out.println("getCurrentDirectory(): "+ jfc.getCurrentDirectory());
	                File[] files = jfc.getSelectedFiles();
	                projectDir = new File(jfc.getSelectedFile().toString());
	                System.out.println("----------------------------"+projectDir);
	                /*--------------------------------------------
	                for (File f: files) {
	                	String tc=jfc.getCurrentDirectory()+"\\"+f.getName();
	                	testclasses.add(tc);
	                	//System.out.println(tc);
	                }
	                //System.out.println("getSelectedFile() : "+ jfc.getSelectedFile());
	                app=jfc.getSelectedFile().toString();
	                testFilePath=jfc.getSelectedFile().toString();
	                System.out.println(testFilePath);
	                ---------------------------------------------------*/
	                
	            } else {
	                System.out.println("No Selection ");
	            }
				
				
		        new DirExplorer((level, path, file) -> path.endsWith(".java") && (path.contains("Test") || path.contains("test")),
		        		(level, path, file) -> {
		        			String temp=path;
		        			temp=temp.replace("/", "\\\\");
		        			temp=projectDir+temp;
		        		testWithFullPath.add(temp);
		            System.out.println("paaaaaaaaaaaaaaattttttttttttthhhhhhhhhhhh "+temp);
		            //System.out.println(Strings.repeat("=", path.length()));
		            
		           
		                try {
							new VoidVisitorAdapter<Object>() {
							    @Override
							    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
							        super.visit(n, arg);
							        //System.out.println(" * " + n.getName());
							        testclasses.add( n.getName().asString());
							    }
							}.visit(JavaParser.parse(file), null);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                System.out.println(); // empty line

		            
		            
		        }).explore(projectDir);
		        
		        for(String t:testclasses) {
					System.out.println("fsadf "+t);
				}
			}
			     
	    } );
		
		
		frame.getContentPane().add(btnSelect);
		
		JLabel lblGeneralFixture = new JLabel("General Fixture");
		lblGeneralFixture.setFont(new Font("Tempus Sans ITC", Font.BOLD, 44));
		lblGeneralFixture.setBounds(363, 41, 323, 43);
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
		table.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(75, 0, 130)));
		table.setBackground(new Color(230, 230, 250));
		table.setFont(new Font("AppleGothic", Font.BOLD,15));
		table.setRowHeight(30);
		table.setBounds(12, 201, 1165, 429);
		JScrollPane scrollPane = new JScrollPane(table);
		JPContainer.add(scrollPane);
		frame.getContentPane().add(table); 
        //frame.pack(); 
		table.setDefaultEditor(Object.class, null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
        frame.setResizable(false);
		//frame.getContentPane().add(JPContainer);
		btnNewButton.setBounds(822, 130, 173, 36);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		btnDetectSmell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//System.out.println("popo");
				Initialization init= new Initialization(testWithFullPath, testclasses);
				init.createTestFile();
				
				
				try {
					init.writeResult();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				filePath=init.resultsWriter.outputFile;
				//System.out.println(filePath);
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}