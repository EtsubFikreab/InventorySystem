import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Yeab!");
//The way to accept input from user
Scanner input =new Scanner(System.in);
//Array.
/*
int numbers[]=new int [5];
System.out.println("Enter 5 Numbers: ");
for (int i=0; i<5; i++){
    numbers[i]=input.nextInt();
}
System.out.println("The numebrs are: ");
for (int i=0; i<5; i++){
    System.out.print(numbers[i]+" ");
}
*/
//Two dimentional array.
/*
int twoD [] []=new int [2][];
twoD[0]=new int [5];
twoD[1]=new int [4];
System.out.println("Enter 5 Numbers: ");
for (int i=0; i<5; i++){
    twoD[0][i]=input.nextInt();
}
System.out.println("Enter 4 Numbers: ");
for (int i=0; i<4; i++){
    twoD[1][i]=input.nextInt();
}
                            System.out.println("The first number is: ");
    for (int j=0; j<5; j++){
 System.out.print(twoD[0][j]+" ");
}
System.out.println("");
                            System.out.println("The second number is: ");
    for (int y=0; y<4; y++){
System.out.print(twoD[1][y]+" ");
}
*/
//Initialization array.
/*
int numbers[]={1,2,3,4,5};
int twoD [] []={{5,5,5,5,5},{4,4,4,4}};
        System.out.println("Double array: ");
for (int j=0; j<5; j++){
    System.out.print(twoD[0][j]+" ");
   }
   System.out.println("");
for (int y=0; y<4; y++){
    System.out.print(twoD[1][y]+" ");
    }
    System.out.println(""); //For new line
    System.out.println("Single array: ");   
for (int i=0; i<5; i++){
        System.out.print(numbers[i]+" ");
    }
*/
//equals()
/*
Integer n1 = new Integer(47);
			Integer n2 = new Integer(48);
			System.out.println(n1.equals(n2));
*/
//compareTo() returns        0 if equall          Positive if second          Negative if first
/*
String name="Yeab";
String nickName="Baby";
System.out.println(name.compareTo(nickName) );
*/
//for-each Loop
/*
int sum = 0;
int numbers []={1,5,4,10};
		for (int value : numbers) {
			sum = sum + value; 
		}
    System.out.println("Sum = "+ sum); 
//To access string individually
String sample = "This is a test";
char[] charArray = sample.toCharArray();
for (char ch: charArray) {
	System.out.print(ch + " ");
}
//If we need to access it later its better this way
String test = "This is a test";
System.out.println(""); //For new line
for (char ch: test.toCharArray()) {
	   System.out.print(ch + " ");
}
// Two-D array
System.out.println(""); //For new line
int twoD [] []={{5,5,5,5,5},{4,4,4,4}};
for ( int a[] :twoD ){
    for (int b : a)
    System.out.print(b);
    System.out.println(""); //For new line
}
*/
//continue Statement
/*
for(int m = 5; m < 10; m++) {
    if(m == 7) {
        continue; //will jump to the next m++ if m is 7
    }
    System.out.print(m+ " ");
}
//Continue as a Form of Goto
outer: for (int i=0; i<10; i++) {
    for(int j=0; j<10; j++) {
     if(j > i) {
         System.out.println();
         continue outer; //will go to the first for loop if j is greather than i
        }
     System.out.print(" "+ (i * j));
 }
}
System.out.println();
*/
//Break statment
/*
int num=500;
while (num > 6) {
    if(num == 400) {
        break; //will break or stop when num==400
    }
    System.out.println(num);
    num -= 10;
}
//Break as a form of Goto
boolean t = true;
first: {
  second: {
     third: {
	      System.out.println("Before the break.");
       if(t) break second; //will not execute the second brace when t is true
       System.out.println("This won't execute");
     }
     System.out.println("This won't execute");
   }
   System.out.println("This is after second block.");
}
*/

















    }
}
