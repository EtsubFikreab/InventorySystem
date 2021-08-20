/**
 * class made for testing and making the genaral functions
 * the functions will be changed to output and input from the monitor(GUI)
 */
public class General {
    public static void main(String[] args){
        
    }
    
}
class Product {
    String name;
    double quantity, priceSold, priceBought;
    void getProduct(){

    }

}
//credit: yoni's contribution
class Sell{
    int sellID, pID, CID;
    double quantity, price;
    String Date;
}
class Supplier{
	int SID;
	String Sname;
	String SAddress;
	int phone;
	short POBOX;
	String SEmail;
	String SDesc;
}
 class buy{
	 int SID;
	 int StID;
	 int PID;
	 int Quantity;
	 double Price;
	 String Date;
 }
 class sell{
	 int StID;
	 int PID;
	 int CID;
	 int Quantity;
	 double Price;
	 String Date;
 }
 class Stuff{
	 String Fname;
	 String Lname;
	 int StID;
	 String StAddress;
	 int Stphone;
	 String StEmail;
 }
 class Customer{
	 String Fname;
	 String Lname;
	 int CID; 
	 String CAddress;
	 int Cphone;
	 String CEmail;
 }
 class Catagory{
	 String CatName;
	 int CatID;
	 String CatDesc;
 }
 class Storage{
	 String StorageArea;
	 int StorageID;
	 String StoDesc;
 }