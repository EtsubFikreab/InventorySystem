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
           String host = "jdbc:mysql://localhost:3306/inventory_system";
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
        String testCustomer[] = {"Bruce", "Wayne", "12","Gotham City","099922","do@aa.com"};
        customer.write(testCustomer);
    }
    
}
