package org.example.septemberApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task_1 {
    List<Integer> arrayOfIteger = new ArrayList<>();
    List<Integer> arrayOfNullElement = new ArrayList<>();
    void GetResultTask_1(){

        for(int i=1; i<=100; i++){
            int x = (int) (Math.random() * 9); // от 0 до 9
            if(x == 0){
                arrayOfNullElement.add(i);
            }
            arrayOfIteger.add(x);
            System.out.println(i + ": " + x + "; ");
        }

        if(arrayOfNullElement.size()>0){
            System.out.print("Индексы нулевых элементов: ");
            for(int i: arrayOfNullElement){
                System.out.print(i + " ");
            }
            System.out.println("");
        }

        // идея такая, что мы храним макисмальное число и минимальное из повторяющихся
        // если их счетчики равны, то мы выводим наименьшее из них
        HashMap<Integer, Integer> mapForCheckDoodles = new HashMap<>();
        int maxDupl = 0; // большее число
        int minDupl = 0; // меньшее повторяющиеся число
        // их счетчики
        int maxCount = 0;
        int minCount = 0;


        for(int i: arrayOfIteger){
            Integer valueForCheck = mapForCheckDoodles.get(i);
            if(valueForCheck == null){
                mapForCheckDoodles.put(i, 1); // если число встречается впервые то мы устанавливаем в значение 1
            }
            else{
                mapForCheckDoodles.put(i, ++valueForCheck);
                // тк такое число уже было, проверяем его счетчик, насколько оно встречается больше других

                if (valueForCheck > maxCount || valueForCheck > minCount) {// условие для вывода меньшего числа
                        if(i>maxDupl){
                            maxDupl=i;
                            maxCount = valueForCheck;
                        }else{
                            minCount = valueForCheck;
                            minDupl=i;
                        }
                    }
            }
        }
        if (maxCount == minCount){
            System.out.println("Самое частое число: " + minDupl + " с количеством повторений = " + minCount);
        }
        else if(maxCount > minCount){
            System.out.println("Самое частое число: " + maxDupl + " с количеством повторений = " + maxCount);
        }else{
            System.out.println("Самое частое число: " + minDupl + " с количеством повторений = " + minCount);
        }
        //System.out.println(maxCount + " "+ minCount);
    }
}
