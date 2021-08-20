package Manipulate;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Staff extends Connect {
    String Fname;
	 String Lname;
	 int StID;
	 String StAddress;
	 int Stphone;
	 String StEmail;
     ResultSet rs;
     public String [] read(){
        String[] results = new String[6];
        try{
            String SQL = "SELECT * FROM staff";
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            results[0] = rs.getString("Fname");
            results[1] = rs.getString("Lname");
            results[2] = Integer.toString(rs.getInt("staffID"));
            results[3] = rs.getString("staffAddress");
            results[4] = rs.getString("staffPhone");
            results[5] = rs.getString("staffEmail");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    public void write(String result[]){
        try{
            String SQL = "SELECT * FROM staff";
            rs = stmt.executeQuery( SQL );
            rs.moveToInsertRow( );
            rs.updateString("Fname",  result[0]);
            rs.updateString("Lname",  result[1]);
            rs.updateInt("storageID", Integer.parseInt(result[2]));
            rs.updateString("staffAddress",  result[3]);
            rs.updateString("staffPhone", result[4]);
            rs.updateString("staffEmail", result[5]);
            
            rs.insertRow( );
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
