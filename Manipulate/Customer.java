package Manipulate;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Customer extends Connect implements reader{
    String Fname;
    String Lname;
    int CID; 
    String CAddress;
    int Cphone;
    String CEmail;
    ResultSet rs;
    public String [] read(){
        String [] result = new String[6];
        try{
            String SQL = "SELECT * FROM  Customer";
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table
            rs.next( );
            result[0] = rs.getString("Fname");
            result[1] = rs.getString("Lname");
            result[2] = Integer.toString(rs.getInt("customerID"));
            result[3] = rs.getString("customerAddress");
            result[4] = rs.getString("customerPhone");
            result[5] = rs.getString("customerEmail");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return result;
  }
    public void write(String result[]){
        try{
            String SQL = "SELECT * FROM Customer";
            rs = stmt.executeQuery( SQL );
            rs.moveToInsertRow( );
            rs.updateString("Fname",(result[0]));
            rs.updateString("Lname",(result[1]));
            rs.updateString("customerAddress",(result[3]));
            rs.updateString("customerPhone",(result[4]));
            rs.updateString("customerEmail",(result[5]));
            rs.insertRow();
          }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
    }

    public String[] readNext(){
        String results[] = new String[6];
        try {
            if ( rs.next( )) {
                results[0] = rs.getString("Fname");
                results[1] = rs.getString("Lname");
                results[2] = Integer.toString(rs.getInt("customerID"));
                results[3] = rs.getString("customerAddress");
                results[4] = rs.getString("customerPhone");
                results[5] = rs.getString("customerEmail");
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
        String results[] = new String[6];
        try {
            if ( rs.previous( )) {
                results[0] = rs.getString("Fname");
                results[1] = rs.getString("Lname");
                results[2] = Integer.toString(rs.getInt("customerID"));
                results[3] = rs.getString("customerAddress");
                results[4] = rs.getString("customerPhone");
                results[5] = rs.getString("customerEmail");
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
        String results[] = new String[6];
        try {
            rs.last();
            results[0] = rs.getString("Fname");
            results[1] = rs.getString("Lname");
            results[2] = Integer.toString(rs.getInt("customerID"));
            results[3] = rs.getString("customerAddress");
            results[4] = rs.getString("customerPhone");
            results[5] = rs.getString("customerEmail");
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return results;
    }

    public boolean updateRow( String result[]){
        try {
            rs.updateString("Fname",(result[0]));
            rs.updateString("Lname",(result[1]));
            rs.updateString("customerAddress",(result[3]));
            rs.updateString("customerPhone",(result[4]));
            rs.updateString("customerEmail",(result[5]));
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
            //TO DO  implement read() in the event handler (button)
            JOptionPane.showMessageDialog(null, "Succesfully Deleted");
        }
        catch (SQLException err){
            System.out.println(err.getMessage());
            return false;
        }
        return true;
    }

}