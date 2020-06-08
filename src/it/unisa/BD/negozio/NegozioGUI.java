package it.unisa.BD.negozio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NegozioGUI {

	private JFrame frmNegozioDiMusica;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField idClienteTextField;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField nascitaTextField;
	private JTextField telefonoTextField;
	private JTextField viaTextField;
	private JTextField cittaTextField;
	private JTextField capTextField;
	
	private DbManagement db;
	ResultSet risp;
	
	String url = "jdbc:mysql://localhost:3306/negoziomusica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String usr;
	String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NegozioGUI window = new NegozioGUI();
					window.frmNegozioDiMusica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NegozioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNegozioDiMusica = new JFrame();
		frmNegozioDiMusica.setTitle("Negozio di Musica");
		frmNegozioDiMusica.setBounds(100, 100, 578, 413);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frmNegozioDiMusica.setLocation(d.width/2-289, d.height/2-206);
		frmNegozioDiMusica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNegozioDiMusica.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmNegozioDiMusica.getContentPane().add(panel, "name_240808443954685");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		frmNegozioDiMusica.getContentPane().add(panel_1, "name_241287023452962");
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		frmNegozioDiMusica.getContentPane().add(panel_2, "name_256066959505461");
		panel_2.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(23, 22, 70, 24);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(23, 68, 70, 20);
		panel.add(lblPassword);
		
		userField = new JTextField();
		userField.setBounds(118, 24, 89, 20);
		panel.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 68, 89, 20);
		panel.add(passwordField);
		
		JTextArea textAreaConnection = new JTextArea();
		textAreaConnection.setBounds(347, 66, 90, 22);
		panel.add(textAreaConnection);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usr = userField.getText();
					password = passwordField.getText();
					db = new DbManagement(url,usr,password);
					//textAreaConnection.setText("Connected");
					panel.setVisible(false);
					panel_1.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textAreaConnection.setText("Error Connection DB: "+e1.toString());
				}
			}
		});
		
		
		btnConnect.setBounds(348, 23, 89, 23);
		panel.add(btnConnect);
		/*
		JPanel panel_1 = new JPanel();
		frmNegozioDiMusica.getContentPane().add(panel_1, "name_241287023452962");
		panel_1.setLayout(null);
		*/
		JLabel lblIDCliente = new JLabel("ID_Cliente");
		lblIDCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIDCliente.setBounds(22, 25, 74, 14);
		panel_1.add(lblIDCliente);
		
		idClienteTextField = new JTextField();
		idClienteTextField.setBounds(106, 22, 86, 20);
		panel_1.add(idClienteTextField);
		idClienteTextField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(289, 25, 78, 14);
		panel_1.add(lblNome);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(377, 22, 86, 20);
		panel_1.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(22, 73, 74, 14);
		panel_1.add(lblCognome);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setBounds(106, 70, 86, 20);
		panel_1.add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		JLabel lblDatanascita = new JLabel("DataNascita");
		lblDatanascita.setBounds(289, 73, 78, 14);
		panel_1.add(lblDatanascita);
		
		nascitaTextField = new JTextField();
		nascitaTextField.setBounds(376, 70, 86, 20);
		panel_1.add(nascitaTextField);
		nascitaTextField.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(22, 129, 74, 14);
		panel_1.add(lblTelefono);
		
		telefonoTextField = new JTextField();
		telefonoTextField.setBounds(106, 126, 86, 20);
		panel_1.add(telefonoTextField);
		telefonoTextField.setColumns(10);
		
		JLabel lblVia = new JLabel("Via");
		lblVia.setBounds(289, 129, 78, 14);
		panel_1.add(lblVia);
		
		viaTextField = new JTextField();
		viaTextField.setBounds(377, 126, 86, 20);
		panel_1.add(viaTextField);
		viaTextField.setColumns(10);
		
		JLabel lblCitta = new JLabel("Citta");
		lblCitta.setBounds(22, 183, 59, 14);
		panel_1.add(lblCitta);
		
		cittaTextField = new JTextField();
		cittaTextField.setBounds(105, 180, 86, 20);
		panel_1.add(cittaTextField);
		cittaTextField.setColumns(10);
		
		JLabel lblCap = new JLabel("Cap");
		lblCap.setBounds(289, 183, 78, 14);
		panel_1.add(lblCap);
		
		capTextField = new JTextField();
		capTextField.setBounds(377, 180, 86, 20);
		panel_1.add(capTextField);
		capTextField.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(106, 274, 359, 36);
		panel_1.add(textArea_1);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.insertQuery(idClienteTextField.getText(), nomeTextField.getText(), cognomeTextField.getText(), nascitaTextField.getText(), telefonoTextField.getText(), viaTextField.getText(), cittaTextField.getText(), capTextField.getText());
					textArea_1.setText("Insert DB Success");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textArea_1.setText("Error Insert DB: "+ e1.toString());
				}
			}
		});
		btnInsert.setBounds(106, 240, 89, 23);
		panel_1.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.updateQuery(idClienteTextField.getText(), nomeTextField.getText(), cognomeTextField.getText(), nascitaTextField.getText(), telefonoTextField.getText(), viaTextField.getText(), cittaTextField.getText(), capTextField.getText());
					textArea_1.setText("Update DB Success");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textArea_1.setText("Error Update DB: "+ e1.toString());
				}
			}
		});
		btnUpdate.setBounds(244, 240, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnSwtich1 = new JButton("Swtich");
		btnSwtich1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnSwtich1.setBounds(374, 240, 89, 23);
		panel_1.add(btnSwtich1);
		
		/*
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(106, 274, 359, 36);
		panel_1.add(textArea_1);
		*/
		
		/*
		JPanel panel_2 = new JPanel();
		frmNegozioDiMusica.getContentPane().add(panel_2, "name_256066959505461");
		panel_2.setLayout(null);
		*/
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 4, 22);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 11, 542, 261);
		panel_2.add(scrollPane);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					risp = db.executeQuery(textArea.getText());
					ResultSetMetaData rsmd = (ResultSetMetaData) risp.getMetaData();
					int columnsNumber = rsmd.getColumnCount();
					textArea.append("\n");
					while(risp.next())
					{
						textArea.append("\n");
						for (int i = 1; i <= columnsNumber; i++) 
						{
							if (i > 1) textArea.append(",  ");
					        String columnValue = risp.getString(i);
					        textArea.append(rsmd.getColumnName(i) + ": " +  columnValue);
					    }
					textArea.append("");
					}
					risp.close();
					
				} catch  (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textArea.setText("Errore Query DB: "+e1.toString());
				}
			}
		});
		btnQuery.setBounds(65, 302, 89, 23);
		panel_2.add(btnQuery);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnReset.setBounds(222, 302, 89, 23);
		panel_2.add(btnReset);
		
		JButton btnSwitch2 = new JButton("Switch");
		btnSwitch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnSwitch2.setBounds(370, 302, 89, 23);
		panel_2.add(btnSwitch2);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					db.close();
					panel_2.setVisible(false);
					panel.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisconnect.setBounds(370, 336, 89, 23);
		panel_2.add(btnDisconnect);
		
	}
}
