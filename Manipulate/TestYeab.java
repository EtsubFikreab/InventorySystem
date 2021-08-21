package Manipulate;
import java.sql.Statement;
public class TestYeab {
    static Statement stmt = Doconnect.function();
    public static void main(String[] args){
        // Buy buy = new Buy();
        // buy.setStatement(stmt);
        // String testBuy[] = {"5","10.5"};
        // buy.write(testBuy);
        Supplier supplier = new Supplier();
        supplier.setStatement(stmt);
        String testSupplier[] = {"Yeabsira Tilahun","Algeria Street", "Yeabsiratilahun78@gmail.com","2310", "we Supply viagra"};
        supplier.updateRow(testSupplier);

        
    
    }
    


   










}
