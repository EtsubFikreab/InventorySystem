/**
 * All functions in the package are accessible from this class.
 * 
 * If you want to create other files within this package make sure that they
 * are only accessible from this class.
 * 
 * When making changes or adding functions make sure your write an example
 * of how the function responds to the data
 * i.e. write input data and expected output data 
 */
package Statistics;
public class Statistics{
    public static void main(String[] args) {
        //function made for testing purposes
        Statistics s = new Statistics();
        s.profit(12,12,5);
        System.out.println(totalProfit);
    }
    static double totalProfit=0;
    void profit (double priceBought, double priceSold, double quantitySold){
        //quantity is double because items like consumables can be sold in fractions 
        //eg sugar 0.5kg
        /**
         * sample:
         * IN: 12 15 5
         * OUT: 15
         * 
         * IN: 15 12 5
         * OUT: -15
         * 
         * IN: 12 12 5
         * OUT: 0
         */
         totalProfit += (priceSold - priceBought)*quantitySold;
    }

}
