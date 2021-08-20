package Manipulate;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Product extends Connect{
    String name;
    double quantity, priceSold, priceBought;
    ResultSet rs;
    public String [] read(){
        String[] results = new String[7];
        try{
            String SQL = "SELECT * FROM product";
    
  
    
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            results[0] = rs.getString("productName");
            results[1] = Integer.toString(rs.getInt("productID"));
            results[2] = Double.toString(rs.getDouble("productPrice"));
            // String date = rsCus.getString("importDate");
            results[3] = rs.getString("productDescription");
            results[4] = Integer.toString(rs.getInt("productQuantity"));
            results[5] = Integer.toString(rs.getInt("catagoryID"));
            results[6] = Integer.toString(rs.getInt("storageID"));
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    public void write(String result[]){

    }
}