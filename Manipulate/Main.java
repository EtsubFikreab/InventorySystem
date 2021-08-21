package Manipulate;

import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
    static Statement stmt = doconnect();
    static Statement doconnect (){
        Connection con;
        Statement stmt=null;
        try{
           String host = "jdbc:mysql://localhost:3306/inventorySystem";
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
    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setStatement(stmt);
        String results[]=new String[6];
        results = customer.read();
         String testCustomer[] = {"Barry", "Allen", "12","Central City","4722","flash@justiceleague.com"};
         customer.updateRow(testCustomer);
        // System.out.println(results[0]);
        
        // results = customer.readLast();
        // System.out.println(results[0]);
        
        // results = customer.readPrevious();
        // results = customer.readPrevious();
        // //unless called twice doesnt work
       
        // System.out.println(results[0]);
      
    }
    
}
