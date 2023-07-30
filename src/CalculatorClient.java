import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");

            Calculator calculator = (Calculator) registry.lookup("Calculator");
            String clientID = calculator.getClientID();
            int num;
             do {
                 System.out.println("----------------------------------------------------");
                 System.out.println("Enter your Choice: ");
                 System.out.println("1  Push Value");
                 System.out.println("2) Pop value");
                 System.out.println("3) Delay Pop value");
                 System.out.println("4) Push Operation");
                 System.out.println("5) Print Stack");
                 System.out.println("6) Get Client Reference");
                 System.out.println("-1)  Exit");
                 System.out.println("----------------------------------------------------");
                 System.out.print("Your Choice: ");
                 num = sc.nextInt();
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
                         System.out.println("Stack: " + calculator.stackState(clientID));
                         break;
                     case 6:
                         System.out.println(calculator.getClientID());
                         break;
                 }
            } while (num != -1);
        } catch (Exception ignore) {}
    }
}
