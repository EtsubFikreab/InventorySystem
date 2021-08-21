package Manipulate;

import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Category extends Connect implements reader{
    String CatName;
    int CatID;
    String CatDesc;
    ResultSet rs;
    public  void doConnect(){

    }
    public String [] read(){
        String [] results = new String [3];

        try{
            
            String SQL = "SELECT * FROM category";
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            int id_col = rs.getInt("CatID");
            results[0] = Integer.toString(id_col);
            results[1] = rs.getString("CatName");
            results[2] = rs.getString("Description");
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
            }
        return results;
    }
    public void write(String result[]){
        try{
            String SQL = "SELECT * FROM Category";
            rs = stmt.executeQuery( SQL );
            rs.moveToInsertRow( );
            rs.updateInt("CatID", Integer.parseInt(result[0]));
            rs.updateString("CatName",(result[1]));
            rs.updateString("Description",(result[2]));
            rs.insertRow();
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }

    }

    public String[] readNext(){
        String results[] = new String[3];
        try {
            if ( rs.next( )) {
                int id_col = rs.getInt("CatID");
                results[0] = Integer.toString(id_col);
                results[1] = rs.getString("CatName");
                results[2] = rs.getString("Description");
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
                int id_col = rs.getInt("CatID");
                results[0] = Integer.toString(id_col);
                results[1] = rs.getString("CatName");
                results[2] = rs.getString("Description");
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
            int id_col = rs.getInt("CatID");
            results[0] = Integer.toString(id_col);
            results[1] = rs.getString("CatName");
            results[2] = rs.getString("Description");
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return results;
    }
    public boolean deleteRow(){
        try{
            rs.deleteRow( );
            //TODO  implement read() in the event handler (button)
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
            rs.updateInt("CatID", Integer.parseInt(result[0]));
            rs.updateString("CatName",(result[1]));
            rs.updateString("Description",(result[2]));
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
