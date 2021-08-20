package Manipulate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sell extends Connect {
  int StID;
	 int PID;
	 int CID;
	 int Quantity;
	 double Price;
	 String Date;
   ResultSet rs;

  public String[] read(){
    String[] results = new String[5];
        try{
            String SQL = "SELECT * FROM sell";
    
  
    
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            results[0] = Integer.toString(rs.getInt("staffID"));
            results[1] = Integer.toString(rs.getInt("productID"));
            results[2] = Integer.toString(rs.getInt("customerID"));
            results[3] = Integer.toString(rs.getInt("quantity"));
            results[4] = Double.toString(rs.getDouble("price"));
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
  }  

  public void write(String results[]){

  }
}
