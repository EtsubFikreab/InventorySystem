package Manipulate;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class Product extends Connect implements reader{
    String name;
    double quantity, priceBought;
    ResultSet rs;
    public String [] read(){
        String[] results = new String[7];
        try{
            String SQL = "SELECT * FROM product";    
            rs = stmt.executeQuery( SQL );
            //hold all the records from the database table

            rs.next( );
            results[0] = rs.getString("productName");
            results[1] = Integer.toString(rs.getInt("productID"));
            results[2] = Double.toString(rs.getDouble("productPrice"));
            // String date = rsCus.getString("importDate");
            results[3] = rs.getString("productDescription");
            results[4] = Integer.toString(rs.getInt("productQuantity"));
            results[5] = Integer.toString(rs.getInt("categoryID"));
            results[6] = Integer.toString(rs.getInt("storageID"));
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return results;
    }
    public void write(String result[]){
        try{
            
            String host = "jdbc:mysql://localhost:3306/inventory_system";
            String username = "root";
            con = DriverManager.getConnection( host, username, "7899" );

            stmt = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_UPDATABLE );
            
            String SQL = "CALL `addProduct`(" + result[0] + "," + Double.parseDouble(result[2]) + "," + result[3] + 
                    "," + Integer.parseInt(result[4]) + "," + Integer.parseInt(result[5]) + "," + Integer.parseInt(result[6]) + ")";
//            String SQL = "Select * from product";
            stmt.executeQuery( SQL );
//            rs.moveToInsertRow( );
//            rs.updateString("productName", result[0]);
////          //THIS ARE COMMENTED BECAUSE THE ID PART IS AUTO INCREAMENT BY THE DATABASE
////          //  rs.updateInt("productID",  Integer.parseInt(result[1]));
//            rs.updateDouble("productPrice", Double.parseDouble(result[2]));
////            // TO DO insert date
//            rs.updateString("productDescription", result[3]);
//            rs.updateInt("productQuantity", Integer.parseInt(result[4]));
//            rs.updateInt("categoryID",  Integer.parseInt(result[5]));
//            rs.updateInt("storageID",  Integer.parseInt(result[6]));
//            SQL = "Insert into product(importDate) value (NOW()) where ";
//            stmt.executeQuery(SQL);
//            rs.insertRow( );
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
            results[0] = rs.getString("productName");
            results[1] = Integer.toString(rs.getInt("productID"));
            results[2] = Double.toString(rs.getDouble("productPrice"));
            // String date = rsCus.getString("importDate");
            results[3] = rs.getString("productDescription");
            results[4] = Integer.toString(rs.getInt("productQuantity"));
            results[5] = Integer.toString(rs.getInt("categoryID"));
            results[6] = Integer.toString(rs.getInt("storageID"));
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
            results[0] = rs.getString("productName");
            results[1] = Integer.toString(rs.getInt("productID"));
            results[2] = Double.toString(rs.getDouble("productPrice"));
            // String date = rsCus.getString("importDate");
            results[3] = rs.getString("productDescription");
            results[4] = Integer.toString(rs.getInt("productQuantity"));
            results[5] = Integer.toString(rs.getInt("categoryID"));
            results[6] = Integer.toString(rs.getInt("storageID"));
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
            results[0] = rs.getString("productName");
            results[1] = Integer.toString(rs.getInt("productID"));
            results[2] = Double.toString(rs.getDouble("productPrice"));
            // String date = rsCus.getString("importDate");
            results[3] = rs.getString("productDescription");
            results[4] = Integer.toString(rs.getInt("productQuantity"));
            results[5] = Integer.toString(rs.getInt("categoryID"));
            results[6] = Integer.toString(rs.getInt("storageID"));
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
            rs.updateString("productName", result[0]);
        //THIS ARE COMMENTED BECAUSE THE ID PART IS AUTO INCREAMENT BY THE DATABASE
         //   rs.updateInt("productID",  Integer.parseInt(result[1]));
            rs.updateDouble("productPrice", Double.parseDouble(result[2]));
            // TO DO insert date
            rs.updateString("productDescription", result[3]);
            rs.updateInt("productQuantity", Integer.parseInt(result[4]));
            rs.updateInt("categoryID",  Integer.parseInt(result[5]));
            rs.updateInt("storageID",  Integer.parseInt(result[6]));
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Updated");
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
        return true;
    }
        public String[] loadProductID () { 
            String result[]=null;
            
            try{
                    String size = "CALL `getProductNumber`();";
                    ResultSet rs = stmt.executeQuery( size );
                    int arrySize =rs.getInt("COUNT(*)");
                    System.out.println("Array Size:"+arrySize);
                    result= new String[arrySize];
                    
                    String SQL = "SELECT productID FROM product";

                    rs = stmt.executeQuery( SQL );
                    //hold all the records from the database table
                    int i =0;
                     while (rs.next())
                     {   
                      result[i]=Integer.toString( rs.getInt("productID")); // Adding Items
                      i++;
                     }//end while
                     con.close();
                  
                }
                catch ( SQLException err ) {
                    System.out.println("error");
                    System.out.println( err.getMessage( ) );
                }     
            return result;
        }


}
