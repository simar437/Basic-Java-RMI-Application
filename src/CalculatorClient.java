import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Calculator calculator = (Calculator) registry.lookup("Calculator");
            int num;
             do {
                 System.out.println("Enter your Choice: ");
                 System.out.println("1 - Push Value");
                 System.out.println("2 - Print Stack");
                 System.out.println("-1 - Exit");
                 num = sc.nextInt();
                 if (num == 1) {
                     System.out.print("Enter a number to push in the stack: ");
                     calculator.pushValue(sc.nextInt());
                 }
                 if (num == 2) {
                     System.out.println("Stack: " + calculator.stackState());
                 }
            } while (num != -1);

        } catch (Exception ignore) {}
    }
}
