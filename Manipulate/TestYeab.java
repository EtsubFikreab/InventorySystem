package Manipulate;
import java.sql.Statement;
public class TestYeab {
    static Statement stmt = Doconnect.function();
    public static void main(String[] args){
        Buy buy = new Buy();
        buy.setStatement(stmt);
    }

















}
