/*Реализуйте алгоритм сортировки пузырьком числового массива, результат после 
каждой итерации запишите в лог-файл. */
package Homework2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Task2 {
    
    public static void main(String[] args) throws SecurityException, IOException {
        int [] testArray = {2,7,3,6,1,9,15};
        int [] bSorter = BubbleSort(testArray);
        System.out.println(Arrays.toString(bSorter)); 
    }
    private static int[] BubbleSort(int[] array) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = null;
        fh = new FileHandler("Homework2/Task2log.xml",true);
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
                logger.log (Level.INFO, "Next point");
            }
        }
            return array;
    }
}
    
    

    
