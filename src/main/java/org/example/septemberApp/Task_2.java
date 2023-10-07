package org.example.septemberApp;

import java.util.Scanner;

public class Task_2 {
    public void GetResultTask_2() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = console.nextLine();
        int count  = 0; // лишние пробелы
        int countAll = 0;// все все пробелы

        for (int i = 0; i < text.length()-1; i++) {
            // 2 условия для счетчика всех пробелов
            if (text.charAt(i) == ' ' ){
                ++countAll;
            }
            if (text.charAt(i+1) == ' ' && i ==text.length()-2){
                ++countAll;
            }

            // проверка на лишний пробел
            // это при условии что я правильно поняла задание и крайние пробелы не засчитывать

            if (text.charAt(i) == ' ' && text.charAt(i+1) == ' ') { // если после пробела идет второй пробел
                count++;
            }

            //if (i == text.length()-2 && text.charAt(i+1) == ' ') {
            //    count++;
            //}
            //if (i == 0 && text.charAt(i) ==  ' ') {
            //    count++;
            //}
        }
        // разности всех и лишних = оставшиеся
        int countLeft = countAll-count;
        String result = text.trim().replaceAll(" +", " ");

        String new_result = result + " ";
        System.out.println("Результат: " + new_result);
        System.out.println("Количество всех пробелов: " + countAll);
        System.out.println("Количество лишних пробелов: " + count);
        System.out.println("Количество оставшихся пробелов: " + countLeft);


    }
}
