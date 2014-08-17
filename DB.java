import java.sql.*;
import javax.swing.*;
import java.awt.Component;
public class DB {
    public static Component frame;
    public static Connection dbconnection=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String DBcreation= ("create database if not exists embit;");
      String DBuse = ("USE embit;");
	  
      String DBtab_Fuser = ("CREATE TABLE IF NOT EXISTS Fuser ("
            +"FuserCode CHAR(5) NOT NULL,"
            +"FName VARCHAR(45) NOT NULL,"
            +"address VARCHAR(45) NOT NULL,"
            +"Contact INTEGER(10) UNSIGNED NOT NULL,"
            +"Email VARCHAR(25) NOT NULL,"
            +"PRIMARY KEY (FuserCode));");
			
      String DBtab_user = ("CREATE TABLE IF NOT EXISTS user ("
            +"userCode CHAR(5) NOT NULL,"
            +"Name VARCHAR(45) NOT NULL,"
            +"Contact INTEGER(10) UNSIGNED NOT NULL,"
            +"Email VARCHAR(25) NOT NULL,"
            +"PRIMARY KEY (userCode));");
       try {
            Class.forName ("com.mysql.jdbc.Driver");
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
            PreparedStatement ps = dbconnection.prepareStatement(DBcreation);
            ps.execute();
            ps = dbconnection.prepareStatement(DBuse);
            ps.executeQuery();
            JOptionPane.showMessageDialog(frame,"embit database is set","Database",JOptionPane.INFORMATION_MESSAGE);
            
            ps = dbconnection.prepareStatement(DBtab_Fuser);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame,"Table 'Fuser' is set","Database",JOptionPane.INFORMATION_MESSAGE);
            
			ps = dbconnection.prepareStatement(DBtab_user);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame,"Table 'user' is set","Database",JOptionPane.INFORMATION_MESSAGE);
            
            
            ps.close();
            dbconnection.close();
            }
       catch (Exception e) {
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Database",JOptionPane.ERROR_MESSAGE);
            }
    }
}

    


