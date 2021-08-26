package Manipulate;

public class Tables {
    public Product product;
    
    public Sell sell;
    public Buy buy;

    public Category category;
    public Supplier supplier;
    public Staff staff;
    public Customer customer;
    public Storage storage;

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
