package Java_Homeworks.Homework5_2023_2;
/*Реализуйте структуру телефонной книги с помощью HashMap, 
учитывая, что 1 человек может иметь несколько телефонов.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Homework5_1{
    public static void main(String[] args) {
        HashMap<String, String> phBk = new HashMap<String, String>();
        phBk.put("8126665544", "Иванов Петр");
        phBk.put("8126665511", "Сидоров Иван");
        phBk.put("8126665522", "Николаев Сидор");
        phBk.put("8126665533", "Кузнецов Николай");
        phBk.put("8126665555", "Иванов Петр");
        phBk.put("8126665566", "Иванов Петр");

        ArrayList<String> names = new ArrayList<String>();
        for (String item: phBk.values()){   //Making an array of sorted names
            int count = 0;
            for (int i = 0; i < names.size(); i++){           
                if (item.contentEquals(names.get(i))){                  
                    count++;
                }   
            }
            if (count == 0){
                names.add(item);
            }
        }
        Collections.sort(names);    // Sorting

        OwnPhonNum(phBk, names);
        WhoseNum(phBk, names);
        PrintPhBk(phBk, names);      
    }
    
    public static String PhonNumParce(String inpStr) {
        String str1 = (inpStr.replaceAll("[()]", ""));// Deleting symbols in the input number
        String str2 = (str1.replaceAll("[-+]", "")).substring(1, 11); 
        return str2;
    }

    public static void WhoseNum(HashMap<String, String> phBk, ArrayList<String> arrLst){
        System.out.println("Enter a phone number  in the format 8-812-111-11-11 :\n");
        Scanner inpScan = new Scanner(System.in);
        String inNum = PhonNumParce(inpScan.nextLine());
        for (String key :phBk.keySet()) {
            if (key.equals(inNum)){     // Printing who is number owner
                System.out.print("\n"+phBk.get(key));
                System.out.printf("\t - %s \n", key);
            }
        }
        inpScan.close();
    }   

    public static void OwnPhonNum(HashMap<String, String> phBk, ArrayList<String> arrLst) {
        System.out.println("Enter the раrt of the number owner's name :");
        Scanner inpScan2 = new Scanner(System.in);
        String inName = inpScan2.next();
        for (String key :phBk.keySet()) {
            // System.out.println(key);
            if (phBk.get(key).contains(inName)){    // Printing the owner's numbers
                System.out.print("\n"+phBk.get(key));
                System.out.printf("\t - %s \n", key);
            }
        }
        inpScan2.close();
    }

    public static void PrintPhBk(HashMap<String, String> phBk, ArrayList<String> arrLst) {
        System.out.println("\n\tPHONE BOOK");
        for (String item: arrLst){            
            System.out.println("\n"+item);      // Printing the phone book
            for (String key :phBk.keySet()) {
                if (phBk.get(key).equals(item)){
                    System.out.printf("\t - %s \n", key); 
                }
            }
        }
    }
}