package Manipulate;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


abstract class Connect {
    static Connection con;
    Statement stmt;
    Connect(){
        try{
           String host = "jdbc:mysql://localhost:3306/inventorysystem";//set name to your own database
           String username = "root";
           con = DriverManager.getConnection( host, username, "" );

           stmt = con.createStatement(
           ResultSet.TYPE_SCROLL_SENSITIVE, 
           ResultSet.CONCUR_UPDATABLE );
       }
       catch ( SQLException err ) {
           System.out.println( err.getMessage( ) );
           }
    }
    public void setStatement(Statement statement) {
        stmt = statement;
    }
    abstract String [] read();
    abstract void write(String result[]);
}


interface reader{
    String[] readNext();
    String[] readPrevious();
    String[] readLast();
    boolean updateRow(String result[]);
    boolean deleteRow()
    ;
}