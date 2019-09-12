package demo.sphinx.helloworld;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Meaning extends JFrame {
	public static 	 String word=null,meaning=null,type=null,sentence=null,s=null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	
	public void display(String b) throws SQLException {

		
		
		
	
		 s=b;
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	    Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","db49","db49");
	    Statement st = conn.createStatement();
	   
	    
	    
	    ResultSet res=null;    
	      res=st.executeQuery("select * from diction where WORD='"+s+"'");
		   while (res.next())
		   {
			   word=res.getString("WORD");
			   meaning=res.getString("MEANING");
			   type=res.getString("TYPEW");
			   sentence=res.getString("SENTENCE");
		   }
	
	
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Meaning frame = new Meaning();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});

	}
	/**
	 * Create the frame.
	 */
	public Meaning() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(word);
		lblNewLabel.setBounds(20, 63, 134, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(type);
		lblNewLabel_2.setBounds(156, 179, 238, 26);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea(meaning);
		textArea.setBounds(198, 74, 196, 72);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea(sentence);
		textArea_1.setBounds(193, 216, 201, 118);
		contentPane.add(textArea_1);
		 
	}
	
	


	
}
