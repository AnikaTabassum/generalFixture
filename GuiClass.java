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
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class GuiClass implements ActionListener {

	private JFrame frame;
	private JTextField textField;



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
	    
		frame.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.out.println("anika");
				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	            chooser.setCurrentDirectory(new java.io.File("F:\\6th_semester\\testing & quality assurance\\cs3-final-project-master\\cs3-final-project-master\\testFinalProject"));
	            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	            jfc.setCurrentDirectory(new java.io.File("F:\\6th_semester\\testing & quality assurance\\cs3-final-project-master\\cs3-final-project-master\\testFinalProject"));
	    		
	            FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java");
	            jfc.setFileFilter(filter);
	            int returnValue = jfc.showOpenDialog(null);
	    		// int returnValue = jfc.showSaveDialog(null);

	    		/*if (returnValue == JFileChooser.APPROVE_OPTION) {
	    			System.out.println("ok");
	    		}*/
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	                System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
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
		lblGeneralFixture.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblGeneralFixture.setBounds(150, 41, 136, 43);
		frame.getContentPane().add(lblGeneralFixture);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
