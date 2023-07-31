import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Welcome to Calculator (Client)");
            Registry registry = LocateRegistry.getRegistry("localhost");
            System.out.println("Establishing connection with the server...");
            Calculator calculator = (Calculator) registry.lookup("Calculator");
            String clientID = calculator.getClientID();
            System.out.println("Connection Successful!!");
            loop: while (true) {
                 System.out.println("----------------------------------------------------");
                 System.out.println("Enter your Choice: ");
                 System.out.println("1  Push Value");
                 System.out.println("2) Pop value");
                 System.out.println("3) Delay Pop value");
                 System.out.println("4) Push Operation");
                 System.out.println("5) Check if Stack is Empty");
                 System.out.println("6) Print Stack");
                 System.out.println("-1)  Exit");
                 System.out.println("----------------------------------------------------");
                 System.out.print("Your Choice: ");
                int num = sc.nextInt();
                 switch (num) {
                     case 1:
                         System.out.print("Enter a number to push in the stack: ");
                         calculator.pushValue(sc.nextInt(), clientID);
                         break;
                     case 2:
                         System.out.println("Value Popped: " + calculator.pop(clientID));
                         break;
                     case 3:
                         System.out.print("Enter delay in milliseconds: ");
                         System.out.println("Value Popped: " + calculator.delayPop(sc.nextInt(), clientID));
                         break;
                     case 4:
                         calculator.pushOperation(sc.next(), clientID);
                         break;
                     case 5:
                         System.out.println("Stack is " + (calculator.isEmpty(clientID) ? "" : "not ") + "empty!");
                         break;
                     case 6:
                         System.out.println("Stack: " + calculator.printStack(clientID));
                         break;
                     case -1:
                         System.out.println("Thank You for using the program");
                         System.out.println("Good Bye!");
                         break loop;
                     default:
                         System.out.println("Please enter a valid operation...");
                 }
            }
        } catch (Exception e) {
            System.out.println("Connection Failed :(");
            e.printStackTrace();
        }
    }
}
