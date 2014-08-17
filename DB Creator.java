import java.sql.*;
import javax.swing.*;
import java.awt.Component;
public class Main {
    public static Component frame;
    public static Connection dbconnection=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String DBcreation= ("create database if not exists embit;");
      String DBuse = ("USE embit;");
      String DBtab_user = ("CREATE TABLE IF NOT EXISTS user ("
            +"userCode CHAR(5) NOT NULL,"
            +"userName VARCHAR(45) NOT NULL,"
            +"address VARCHAR(45) NOT NULL,"
            +"status CHAR(1) NOT NULL,"
            +"dependent INTEGER(1) UNSIGNED NOT NULL,"
            +"familyHead CHAR(1) NOT NULL,"
            +"salary INTEGER(10) UNSIGNED NOT NULL,"
            +"position VARCHAR(25) NOT NULL,"
            +"PRIMARY KEY (userCode));");
       String DBtab_log = ("CREATE TABLE IF NOT EXISTS timelog ("
            +"userCode CHAR(5) NOT NULL,"
            +"date DATE NOT NULL,"
            +"timeIn TIME NOT NULL,"
            +"timeOut TIME NOT NULL,"
            +"remarks VARCHAR(45),"
            +"PRIMARY KEY (userCode));");
      try {
            Class.forName ("com.mysql.jdbc.Driver");
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
            PreparedStatement ps = dbconnection.prepareStatement(DBcreation);
            ps.execute();
            ps = dbconnection.prepareStatement(DBuse);
            ps.executeQuery();
            JOptionPane.showMessageDialog(frame,"embit database is set","Database",JOptionPane.INFORMATION_MESSAGE);
            
            ps = dbconnection.prepareStatement(DBtab_user);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame,"Table 'user' is set","Database",JOptionPane.INFORMATION_MESSAGE);
            
            ps = dbconnection.prepareStatement(DBtab_log);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame,"Table 'timetable' is set","Database",JOptionPane.INFORMATION_MESSAGE);
            ps.close();
            dbconnection.close();
            }
       catch (Exception e) {
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Database",JOptionPane.ERROR_MESSAGE);
            }
    }
}

    


