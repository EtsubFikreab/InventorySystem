package Manipulate;
import java.sql.Statement;
public class TestKidus {
    static Statement stmt = Doconnect.function();
    public static void main(String[] args){
        Category category = new Category();
        category.setStatement(stmt);
        String test[] = {"haha", "chala", "chebude"};
        
        category.write(test);
    }
}
