package Manipulate;
import java.sql.Statement;
import java.sql.ResultSet;
public class Main {
    static Statement stmt = Doconnect.function();
    public static void main(String[] args){
        Customer cust = new Customer();
        Customer.setStatement(stmt);
    }
    
}
