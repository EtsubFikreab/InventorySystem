package Manipulate;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Category extends Connect{
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
}
