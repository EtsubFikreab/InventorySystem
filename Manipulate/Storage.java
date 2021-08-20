package Manipulate;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Storage extends Connect{
    String StorageArea;
	 int StorageID;
	 String StoDesc;
     ResultSet rs;
     public String [] read(){
        String[] results = new String[3];
        try{
            String SQL = "SELECT * FROM storage";    
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table
            rs.next( );
            results[0] = Integer.toString(rs.getInt("storageArea"));
            results[1] = Integer.toString(rs.getInt("storageID"));
            results[2] = rs.getString("Description");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
     }
     public void write(String result[]){
 
     }
}
