
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FileMaker newfile =  new FileMaker("D:\\java\\filemanagement\\newApp.java");
        int choice;
        Scanner scobj = new Scanner(System.in);
        String userInput;

          System.out.println("Enter package:");
                    userInput = scobj.next();
                    newfile.makePackage(userInput);
                    newfile.makePublicClass();

        do{
            System.out.println("""
                               Enter the choice :
                               1. to add a feild 
                               2. to add a Method
                               3. make java file
                               5.Exit
                               """);

            choice = scobj.nextInt();
             


            switch(choice) {
                case 1:
                    System.out.println("Enter feild name:");
                    userInput = scobj.next();
                    System.out.println("1 for int \n 2 for char \n 3 for boolean \n 4 for flaot");
                    int dtype = scobj.nextInt();
                    newfile.makeFeild(userInput, dtype);
                    break;
                case 2:
                    System.out.println("Enter method name");
                    userInput = scobj.next();
                    System.out.println("1 for void \n 2 for int \n 3 for boolean \n 4 for flaot \n 5 for String");
                    int returntype  = scobj.nextInt();
                    System.out.println("is it Static");
                    boolean isStatic = scobj.nextBoolean();
                    newfile.makeMethod(userInput, returntype, isStatic);
                case 3:
                    newfile.writeAll(); 
                      System.out.println("java file creation succesfull");
                    break;
                case 5:
                    break;
                default:
                    throw new AssertionError();
            }

        }while(choice != 5);
        

   
        
    }

    
}
