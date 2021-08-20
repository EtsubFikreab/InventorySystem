package Manipulate;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class Customer extends Connect implements reader{
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
            result[2] = Integer.toString(rs.getInt("CID"));
            result[3] = rs.getString("CAddress");
            result[4] = rs.getString("Cphone");
            result[5] = rs.getString("CEmail");
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
            rs.updateString("Lname",(result[1]));
            rs.updateInt("CID" ,Integer.parseInt(result[3]));
            rs.updateString("Cphone",(result[4]));
            rs.updateString("CEmail",(result[5]));
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
                results[2] = Integer.toString(rs.getInt("CID"));
                results[3] = rs.getString("CAddress");
                results[4] = rs.getString("Cphone");
                results[5] = rs.getString("CEmail");
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
                results[2] = Integer.toString(rs.getInt("CID"));
                results[3] = rs.getString("CAddress");
                results[4] = rs.getString("Cphone");
                results[5] = rs.getString("CEmail");
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
            results[2] = Integer.toString(rs.getInt("CID"));
            results[3] = rs.getString("CAddress");
            results[4] = rs.getString("Cphone");
            results[5] = rs.getString("CEmail");
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return results;
    }
}