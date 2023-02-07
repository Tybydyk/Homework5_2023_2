package Java_Homeworks.Homework5_2023_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * Написать программу, которая найдет и выведет повторяющиеся имена 
 * с количеством повторений. Отсортировать по убыванию популярности Имени.
 */
public class Homework5_2 {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<String, String>();
        names.put("Иванов", "Иван");
        names.put("Петрова", "Светлана");
        names.put("Белова", "Кристина");
        names.put("Мусина", "Анна");
        names.put("Крутова", "Анна");
        names.put("Юрин", "Иван");
        names.put("Лыков", "Петр");
        names.put("Чернов", "Павел");
        names.put("Чернышов", "Петр");
        names.put("Федорова", "Мария");
        names.put("Светлова", "Марина");
        names.put("Савина", "Мария");
        names.put("Рыкова", "Мария");
        names.put("Лугова", "Марина");
        names.put("Владимирова", "Анна");
        names.put("Мечников", "Иван");
        names.put("Петин", "Петр");
        names.put("Ежов", "Иван");

        ArrayList<String> firstName = new ArrayList<String>();
        for (String name : names.values()) {
            int flag = 0;
            for (int i = 0; i < firstName.size(); i++) {
                if (name.contentEquals(firstName.get(i))) {
                    flag++;
                }
            }
            if (flag == 0) {
                firstName.add(name);    // Array with unique names               
            }
        }
        HashMap<String, Integer> fNamesMap = new HashMap<String, Integer>();
        ArrayList<Integer> countList = new ArrayList<Integer>();
        for (String name: firstName){
            int count = 0;
            for (String item : names.values()){
                if (item.equals(name)) count++;
            }
            fNamesMap.put(name, count);    // HashMap with firsn names and count
            countList.add(count);           // countList for sorting
        }
        Collections.sort(countList);        // Sorting
        for (int j = 0; j < countList.size()-1; j++){
            if (countList.get(j+1) == countList.get(j)){
                countList.remove(j);        // Array with an unique count
                j--;
            } 
        }     
        for (int i = countList.size() - 1; i >= 0; i--){    // Printing the name and the number of repetitions
            for (String fnm: fNamesMap.keySet()){
                if (countList.get(i) == (fNamesMap.get(fnm))){
                    System.out.printf("\nThe name [ %s ] is repeated %d times", fnm, countList.get(i));
                } 
            }   
        }        
    }
}
