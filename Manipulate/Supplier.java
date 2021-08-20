package Manipulate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Supplier extends Connect{
  int SID;
	String Sname;
	String SAddress;
	int phone;
	short POBOX;
	String SEmail;
	String SDesc;
  ResultSet rs;

  public String[] read(){
    String[] results = new String[7];
        try{
            String SQL = "SELECT * FROM supplier";
    
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            results[0] = Integer.toString(rs.getInt("supplierID"));
            results[1] = rs.getString("supplierName");
            results[2] = rs.getString("supplierAddress");
            results[3] = rs.getString("supplierPhone");
            results[4] = rs.getString("supplierEmail");
            results[5] = Integer.toString(rs.getInt("POBOX"));
            results[6] = rs.getString("supplierDescription");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
  }

  public void write(String results[]){
    
  }
}
