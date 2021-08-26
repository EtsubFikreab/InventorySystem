package Manipulate;

import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Storage extends Connect implements reader{
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
           // results[0] = Integer.toString(rs.getInt("storageArea"));
            results[0] = rs.getString("storageArea");
            results[1] = Integer.toString(rs.getInt("storageID"));
            results[2] = rs.getString("description");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
     }
     public void write(String result[]){
        try{
            String SQL = "SELECT * FROM storage";    

            rs = stmt.executeQuery( SQL );
            rs.moveToInsertRow( );
            rs.updateString("storageArea",  result[0]);
            rs.updateString("description", result[2]);
            rs.insertRow( );
      
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
        }
 
     }

    public String[] readNext(){
        String results[] = new String[3];
        try {
            if ( rs.next( )) {
               // results[0] = Integer.toString(rs.getInt("storageArea"));
                results[0] = rs.getString("storageArea");
                results[1] = Integer.toString(rs.getInt("storageID"));
                results[2] = rs.getString("description");
            }
            else {
                rs.previous( );
                JOptionPane.showMessageDialog(null, "End of File");
            }
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return results;
    }

    public String[] readPrevious(){
        String results[] = new String[3];
        try {
            if ( rs.previous( )) {
                //results[0] = Integer.toString(rs.getInt("storageArea"));
                results[0] = rs.getString("storageArea");
                results[1] = Integer.toString(rs.getInt("storageID"));
                results[2] = rs.getString("description");
            }
            else {
                rs.next( );
                JOptionPane.showMessageDialog(null, "Start of File");
            }
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return results;
    }

    public String[] readLast(){
        String results[] = new String[3];
        try {
            rs.last();
            //results[0] = Integer.toString(rs.getInt("storageArea")); this is wrong but not sure
            results[0] = rs.getString("storageArea");
            results[1] = Integer.toString(rs.getInt("storageID"));
            results[2] = rs.getString("description");
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return results;
    }

    public boolean updateRow(String result[]){
        try {
            //THIS ARE COMMENTED BECAUSE THE ID PART IS AUTO INCREAMENT BY THE DATABASE
            //   rs.updateInt("storageID", Integer.parseInt(result[1]));
            rs.updateString("storageArea",(result[0])); //area should be string
            rs.updateString("description",(result[2]));
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Updated");
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteRow(){
        try{
            rs.deleteRow( );
            JOptionPane.showMessageDialog(null, "Succesfully Deleted");
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
            return false;
        }
        return true;
    }


}
