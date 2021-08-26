package Manipulate;
import java.sql.Statement;
public class TestYeab {
    static Statement stmt = Doconnect.function();
    public static void main(String[] args){
        // Buy buy = new Buy();
        // buy.setStatement(stmt);
        // String testBuy[] = {"5","10.5"};
        // buy.write(testBuy);

//TO UPDATE WHATS ALREADY THERE

    //SUPPLIER
        // Supplier supplier = new Supplier();
        // //supplier.setStatement(stmt);
        // String result[]=new String[6];
        // result = supplier.read();
        // String testSupplier[] = {"","Yeabsira Tilahun","Algeria Street", "Yeabsiratilahun78@gmail.com","2310", "we Supply viagra"};
        // supplier.updateRow(testSupplier);
        // System.out.println(result[0]);

    //STAFF    
        // Staff staff = new Staff();
        // String result[]=new String[6];
        // result = staff.read();
        // String testStaff[] = {"Thor","Laufeyson","","earth", "0921707226","thor@avengers.com"};
        // staff.updateRow(testStaff);
        // System.out.println(result[0]);

    //STORAGE    
        Storage storage = new Storage();
        String result[]=new String[6];
        result = storage.read();
        String teststorage[] = {"West","","Cosmotics area"};
        storage.updateRow(teststorage);
        System.out.println(result[0]);

     //CATEGORY   
        // Category category = new Category();
        // String result[]=new String[2];
        // result = category.read();
        // String testcategory[] = {"Electronics","","Laptop computers"};
        // category.updateRow(testcategory);
        // System.out.println(result[0]);

    //PRODUCT TABLE
        // Product product = new Product();
        // String result[]=new String[7];
        // result = product.read();
        // String testproduct[] = {"ASUS laptop","","8000","ROG Strix GA35 and ROG Strix GA15 available","4","",""};
        // product.updateRow(testproduct);
        // System.out.println(result[0]);






    
    }
    




    


    // Customer customer = new Customer();
    // customer.setStatement(stmt);
    // String results[]=new String[6];
    // results = customer.read();
    // String testCustomer[] = {"hello", "world", "12","pc","1222","pc@some.com"};
    // customer.updateRow(testCustomer);
    //  System.out.println(results[0]);

}
