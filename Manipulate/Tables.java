package Manipulate;

public class Tables {
    Product product;
    
    Sell sell;
    Buy buy;

    Category category;
    Supplier supplier;
    Staff staff;
    Customer customer;
    Storage storage;

    public void productTables(){
        product = new Product();
    }
    public void TradeTables(){
        sell = new Sell();
        buy = new Buy();
    }
    public void manageTables(){
        category = new Category();
        supplier = new Supplier();
        staff = new Staff();
        customer = new Customer();
        storage = new Storage();
    }
    
}
