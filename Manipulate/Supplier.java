package Manipulate;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Supplier extends Connect implements reader{
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
    try{
      String SQL = "SELECT * FROM Supplier";
      rs = stmt.executeQuery( SQL );
      rs.moveToInsertRow( );
      rs.updateInt("supplierID", Integer.parseInt(results[0]));
      rs.updateString("supplierName",(results[1]));
      rs.updateString("supplierAddress",(results[2]));
      rs.updateString("supplierEmail",(results[3]));
      rs.updateString("POBOX",(results[4]));
      rs.updateString("supplierDescription",(results[4]));
      rs.insertRow();
    }
    catch ( SQLException err ) {
      System.out.println( err.getMessage( ) );
    }


  }

  public String[] readNext(){
    String results[] = new String[7];
    try {
      if ( rs.next( )) {
        results[0] = Integer.toString(rs.getInt("supplierID"));
        results[1] = rs.getString("supplierName");
        results[2] = rs.getString("supplierAddress");
        results[3] = rs.getString("supplierPhone");
        results[4] = rs.getString("supplierEmail");
        results[5] = Integer.toString(rs.getInt("POBOX"));
        results[6] = rs.getString("supplierDescription");
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
    String results[] = new String[7];
    try {
      if ( rs.previous( )) {
        results[0] = Integer.toString(rs.getInt("supplierID"));
        results[1] = rs.getString("supplierName");
        results[2] = rs.getString("supplierAddress");
        results[3] = rs.getString("supplierPhone");
        results[4] = rs.getString("supplierEmail");
        results[5] = Integer.toString(rs.getInt("POBOX"));
        results[6] = rs.getString("supplierDescription");
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
    String results[] = new String[7];
    try {
      rs.last();
      results[0] = Integer.toString(rs.getInt("supplierID"));
      results[1] = rs.getString("supplierName");
      results[2] = rs.getString("supplierAddress");
      results[3] = rs.getString("supplierPhone");
      results[4] = rs.getString("supplierEmail");
      results[5] = Integer.toString(rs.getInt("POBOX"));
      results[6] = rs.getString("supplierDescription");
    }
    catch (SQLException err) {
        JOptionPane.showMessageDialog(null, err.getMessage());
    }
    return results;
  } 
}
