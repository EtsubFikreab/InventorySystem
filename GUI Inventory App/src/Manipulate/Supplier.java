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
      rs.updateString("supplierName",(results[1]));
      rs.updateString("supplierAddress",(results[2]));
      rs.updateString("supplierPhone",(results[3]));
      rs.updateString("supplierEmail",(results[4]));
      rs.updateInt("POBOX",Integer.parseInt((results[5])));
      rs.updateString("supplierDescription",(results[6]));
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
      }
      else {
          rs.previous( );
          JOptionPane.showMessageDialog(null, "End of File");
      }
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

  public String[] readPrevious(){
    String results[] = new String[7];
    try {
      if ( rs.previous( )) {
      }
      else {
          rs.next( );
          JOptionPane.showMessageDialog(null, "Start of File");
      }
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
public boolean updateRow( String result[]){
  try {
    //THIS ARE COMMENTED BECAUSE THE ID PART IS AUTO INCREAMENT BY THE DATABASE 
    // rs.updateInt("supplierID", Integer.parseInt(result[0]));
      rs.updateString("supplierName",(result[1]));
      rs.updateString("supplierAddress",(result[2]));
      rs.updateString("supplierEmail",(result[3]));
      rs.updateString("POBOX",(result[4]));
      rs.updateString("supplierDescription",(result[5]));
      rs.updateRow( );
      JOptionPane.showMessageDialog(null, "Updated");
  }
  catch (SQLException err) {
      System.out.println(err.getMessage());
      return false;
  }
  return true;
}
}
