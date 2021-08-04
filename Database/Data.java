/**
 * Database edditing operations
 * includes querying
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Data{
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    Data(){
        DoConnect();
    }
    public void DoConnect( ) {
        try{
            String host = "jdbc:derby://localhost:1527/Employee";
            String username = "app";
            String password = " ";
            
            con = DriverManager.getConnection( host, username, password );
            stmt = con.createStatement();
            /*ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_UPDATABLE );
            
            //SQL statement
            //TODO: change to tables made
            String SQL = "SELECT * FROM Workers";
            
            
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            ;*/

        
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
            }
    }
    
    //TODO Functions to get rows from all kinds of tables that are defined in the database


}