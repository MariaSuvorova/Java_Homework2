/*В файле содержится строка с исходными данными в такой форме:
{"name":"ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, 
в форме SQL запроса:
SELECT * FROM students WHERE name = "ivanov" AND country = "Russia" 
AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, 
используя StringBuilder. Значения null не включаются в запрос. */

package Homework2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"866");
        System.out.println("Введите данные: ");
        String students = scanner.nextLine();
        students = (students.replace(":", ",")).replaceAll(" ", "");
        String [] studentsinfo = students.split(",");
        for (int i = 0; i < studentsinfo.length; i++) {
            studentsinfo[i] = studentsinfo[i].substring(1, studentsinfo[i].length()-1);
        }
        StringBuilder sqlInquery = new StringBuilder();
        sqlInquery.append("SELECT * FROM students WHERE");
        for (int i = 0; i < studentsinfo.length; i+=2) {
            //if (studentsinfo[i+1] != "null"){   //?почему не работает такая запись?
            if (studentsinfo[i+1].toString().equals("null") != true){
                sqlInquery.append(" " + studentsinfo[i] + " =");
                sqlInquery.append(" \"" + studentsinfo[i+1]+"\"");
                if (i+1 != studentsinfo.length-1){
                sqlInquery.append(" AND");
                }
            }
        }
        scanner.close();
        int resLineLenght = sqlInquery.length();
        if (sqlInquery.substring(resLineLenght-3, resLineLenght).equals("AND")) {
            sqlInquery.delete(resLineLenght-3, resLineLenght);
        }
        System.out.println(sqlInquery);
    }
}
