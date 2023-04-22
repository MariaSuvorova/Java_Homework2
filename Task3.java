/*В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */
package Homework2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("Homework2/list to Task3.txt");) {
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            // Только для латиницы чтение
            //FileReader fr = new FileReader ("/Users/Taylos/Desktop/ДЗ/2 четверть/Java/Homework2/list to Task3.txt")
            //BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while ((line != null)) {
                String students = (line.replace(":", ",")).replaceAll(" ", "");
                String [] studentinfo = students.split(",");
                for (int i = 0; i < studentinfo.length-1; i++) {
                    studentinfo[i] = studentinfo[i].substring(1, studentinfo[i].length()-1);
                }
                StringBuilder resultLine = new StringBuilder();
                resultLine.append("Студент " + studentinfo[1] + " получил ");
                resultLine.append(Integer.parseInt(studentinfo[3]));
                resultLine.append(" по предмету " + studentinfo[5] + ".");    
            System.out.println (resultLine);
            line = reader.readLine();
            }
        }
        catch (IOException ex) {
            System.out.println ("Error: " + ex.getMessage());
        }
    }
}

