package it.unisa.BD.negozio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbManagement {

	private Connection db = null;
		
		public DbManagement(String url, String user, String password) throws ClassNotFoundException, SQLException 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			db = DriverManager.getConnection(url, user, password);
		}
		
		public void insertQuery(String idCliente, String nome, String cognome, String nascita, String tel, String via, String citta, String cap) throws SQLException
		{
			
			PreparedStatement prst = db.prepareStatement("INSERT INTO negoziomusica.cliente (ID_Cliente, Nome, Cognome, DataNascita, Telefono, via, citta, cap) VALUES(?, ?, ?, ?, ?, ?, ?, ?)"); 
			prst.setString(1, idCliente);
			prst.setString(2, nome);
			prst.setString(3, cognome);
			prst.setString(4, nascita);
			prst.setString(5, tel);
			prst.setString(6, via);
			prst.setString(7, citta);
			prst.setString(8, cap);
			prst.executeUpdate();
			prst.close();
		}
		
		public void updateQuery(String idCliente, String nome, String cognome, String nascita, String tel, String via, String citta, String cap) throws SQLException
		{
			if(nome!=null && nome.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET Nome = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, nome);
				prst.executeUpdate();
				prst.close();
			}
			
			if(cognome!=null && cognome.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET Cognome = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, cognome);
				prst.executeUpdate();
				prst.close();
			}
			
			if(nascita!=null && nascita.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET DataNascita = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, nascita);
				prst.executeUpdate();
				prst.close();
			}
			
			if(tel!=null && tel.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET Telefono = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, tel);
				prst.executeUpdate();
				prst.close();
			}
			

			if(via!=null  && via.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET via = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, via);
				prst.executeUpdate();
				prst.close();
			}
			

			if(citta!=null   && citta.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET citta = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, citta);
				prst.executeUpdate();
				prst.close();
			}
			
			if(cap!=null   && cap.compareTo("")!=0) 
			{
				PreparedStatement prst = db.prepareStatement("UPDATE negoziomusica.cliente SET cap = ? WHERE (ID_Cliente =  ? );"); 
				prst.setString(2, idCliente);
				prst.setString(1, cap);
				prst.executeUpdate();
				prst.close();
			}
			
		}
		
		public ResultSet executeQuery(String area) throws SQLException
		{
			ResultSet rst = db.createStatement().executeQuery(area);
			return rst;
		}
		
		public void close() throws SQLException
		{
			if(db!=null)
				db.close();
		}
		
	
}


/*
 * 
 * UPDATE negoziomusica.cliente SET 
 * 
 */