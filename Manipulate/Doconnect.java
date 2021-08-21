/**
 * Connects to the database and returns statement
 */
package Manipulate;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Doconnect {
    
    public static Statement function(){
        Connection con;
        Statement stmt=null;
        try{
<<<<<<< Updated upstream
           String host = "localhost";
=======
           String host = "jdbc:mysql://localhost:3306/inventory_system";
>>>>>>> Stashed changes
           String username = "root";
           con = DriverManager.getConnection( host, username, "" );

           stmt = con.createStatement(
           ResultSet.TYPE_SCROLL_SENSITIVE, 
           ResultSet.CONCUR_UPDATABLE );
       }
       catch ( SQLException err ) {
           System.out.println( err.getMessage( ) );
           }
        return stmt;
   }
}
