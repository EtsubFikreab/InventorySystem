/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package inventoryapp;

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
    ResultSet rs,rsBuy, rsCat, rsCus, rsPro, rsSell, rsStaff, rsStorage, rsSupplier;
    int curRow = 0;
    Doconnect(){
         try{
            String host = "jdbc:mysql://localhost:3306/inventory";
            String username = "root";
            con = DriverManager.getConnection( host, username, "" );

            stmt = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_UPDATABLE );

        
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
    
    public String[] readBuy(){
        String[] results = new String[5];
        try{
            String SQL = "SELECT * FROM buy";
            rsBuy = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsBuy.next( );
            results[0] = Integer.toString(rsBuy.getInt("staffID"));
            results[1] = Integer.toString(rsBuy.getInt("supplierID"));
            results[2] = Integer.toString(rsBuy.getInt("productID"));
            results[3] = Integer.toString(rsBuy.getInt("quantity"));
            results[4] = Double.toString(rsBuy.getDouble("price"));
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    
    public String[] readCustomer(){
        String[] results = new String[6];
        try{
           String SQL = "SELECT * FROM customer";
    
  
    
            rsCus = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsCus.next( );
            results[0] = rsCus.getString("Fname");
            results[1] = rsCus.getString("Lname");
            results[2] = Integer.toString(rsCus.getInt("customerID"));
            results[3] = rsCus.getString("customerPhone");
            results[4] = rsCus.getString("customerAddress");
            results[5] = rsCus.getString("customerEmail"); 
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    
    public String[] readProduct(){
        String[] results = new String[7];
        try{
            String SQL = "SELECT * FROM product";
    
  
    
            rsPro = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsPro.next( );
            results[0] = rsPro.getString("productName");
            results[1] = Integer.toString(rsPro.getInt("productID"));
            results[2] = Double.toString(rsPro.getDouble("productPrice"));
            // String date = rsCus.getString("importDate");
            results[3] = rsPro.getString("productDescription");
            results[4] = Integer.toString(rsPro.getInt("productQuantity"));
            results[5] = Integer.toString(rsPro.getInt("catagoryID"));
            results[6] = Integer.toString(rsPro.getInt("storageID"));
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    
    public String[] readSell(){
        String[] results = new String[5];
        try{
            String SQL = "SELECT * FROM sell";
    
  
    
            rsSell = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsSell.next( );
            results[0] = Integer.toString(rsSell.getInt("staffID"));
            results[1] = Integer.toString(rsSell.getInt("productID"));
            results[2] = Integer.toString(rsSell.getInt("customerID"));
            results[3] = Integer.toString(rsSell.getInt("quantity"));
            results[4] = Double.toString(rsSell.getDouble("price"));
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    
    public String[] readStaff(){
        String[] results = new String[6];
        try{
            String SQL = "SELECT * FROM staff";
    
  
    
            rsStaff = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsStaff.next( );
            results[0] = rsStaff.getString("Fname");
            results[1] = rsStaff.getString("Lname");
            results[2] = Integer.toString(rsStaff.getInt("staffID"));
            results[3] = rsStaff.getString("staffAddress");
            results[4] = rsStaff.getString("staffPhone");
            results[5] = rsStaff.getString("staffEmail");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    
    public String[] readStorage(){
        String[] results = new String[3];
        try{
            String SQL = "SELECT * FROM storage";
    
  
    
            rsStorage = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsStorage.next( );
            results[0] = Integer.toString(rsStorage.getInt("storageArea"));
            results[1] = Integer.toString(rsStorage.getInt("storageID"));
            results[2] = rsStorage.getString("Description");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    
    public String[] readSupplier(){
        String[] results = new String[7];
        try{
            String SQL = "SELECT * FROM supplier";
    
  
    
            rsSupplier = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rsSupplier.next( );
            results[0] = Integer.toString(rsSupplier.getInt("supplierID"));
            results[1] = rsSupplier.getString("supplierName");
            results[2] = rsSupplier.getString("supplierAddress");
            results[3] = rsSupplier.getString("supplierPhone");
            results[4] = rsSupplier.getString("supplierEmail");
            results[5] = Integer.toString(rsSupplier.getInt("POBOX"));
            results[6] = rsSupplier.getString("supplierDescription");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
}
