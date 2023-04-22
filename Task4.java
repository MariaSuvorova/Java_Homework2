/*К калькулятору из предыдущего дз добавить логирование. */
package Homework2;


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.XMLFormatter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Task4 {
    public static void main(String[] args) throws SecurityException, IOException {
        Scanner scanner = new Scanner(System.in,"866");
        
        System.out.println("Что вычисляем? ");
        String str = scanner.nextLine();
        String[] parts = str.split("");
        int num1 = Integer.parseInt(parts[0]);
        String strOp = parts[1];
        char operation = strOp.charAt(0);    
        int num2 = Integer.parseInt(parts[2]);
        scanner.close(); 

        Logger logger = Logger.getLogger(Task4.class.getName());
        FileHandler fh = null;
        fh = new FileHandler("Homework2/Task4log.xml",true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        //System.out.println(Arrays.toString(parts));

        int result=0;
        switch (operation){
            case '+':
                result = num1+num2;
                System.out.printf("%d %c %d = %d\n", num1, operation, num2, result);
                break;
            case '-':
                result = num1-num2;
                System.out.printf("%d %c %d = %d\n", num1, operation, num2, result);
                break;
            case '*':
                result = num1*num2;
                System.out.printf("%d %c %d = %d\n", num1, operation, num2, result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1/num2;
                    System.out.printf("%d %c %d = %d\n", num1, operation, num2, result);
                    break;
                }
                else {
                    System.out.println("Division by zero");
                    break;
                }
        }
        logger.log (Level.INFO, "Next point");
        
    
    }
}
