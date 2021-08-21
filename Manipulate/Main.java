package Manipulate;
import java.sql.Statement;
public class Main {
    static Statement stmt = Doconnect.function();
    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setStatement(stmt);
    }
    
}
