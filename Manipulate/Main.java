package Manipulate;


public class Main {
    //static Statement stmt = doconnect();
    // static Statement doconnect (){
    //     Connection con;
    //     Statement stmt=null;
    //     try{
    //        String host = "jdbc:mysql://localhost:3306/inventorySystem";
    //        String username = "root";
    //        con = DriverManager.getConnection( host, username, "" );

    //        stmt = con.createStatement(
    //        ResultSet.TYPE_SCROLL_SENSITIVE, 
    //        ResultSet.CONCUR_UPDATABLE );
    //    }
    //    catch ( SQLException err ) {
    //        System.out.println( err.getMessage( ) );
    //        }
    //     return stmt;
    // }
    public static void main(String[] args){
        // Customer customer = new Customer();
        // //customer.setStatement(stmt);
        // String results[]=new String[6];
        // results = customer.read();
        // //String testCustomer[] = {"hello", "world", "12","pc","1222","pc@some.com"};
        // //customer.updateRow(testCustomer);
        //  System.out.println(results[0]);

        Supplier supplier= new Supplier();
        String input[] = {"","Loki Laufeyson","Asgard", "12312","loki@avengers.com", "965", "Brother of Thor"};
        supplier.write(input);
        
        // results = customer.readLast();
        // System.out.println(results[0]);
        
        // results = customer.readPrevious();
        // results = customer.readPrevious();
        // //unless called twice doesnt work
       
        // System.out.println(results[0]);
      
    }
    
}
