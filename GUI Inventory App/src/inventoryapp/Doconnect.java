/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EtsubF
 */
public class Doconnect {
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    Doconnect(){
         try{
            String host = "jdbc:mysql://localhost:3306/inventorymanagmentsystem";
            String username = "root";
            con = DriverManager.getConnection( host, username, "" );

            stmt = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_UPDATABLE );
            String SQL = "SELECT * FROM category";
            
          
            
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            int id_col = rs.getInt("CatID");
            String id = Integer.toString(id_col);
            String name = rs.getString("CatName");
            String description = rs.getString("Description");

            
          
        
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
            }
    }
    public String[] readCategory(){
        
        String [] results = new String [3];

        try{
            
            String SQL = "SELECT * FROM category";
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            int id_col = rs.getInt("CatID");
            results[0] = Integer.toString(id_col);
            results[1] = rs.getString("CatName");
            results[2] = rs.getString("Description");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
            }
        return results;
    }
}
