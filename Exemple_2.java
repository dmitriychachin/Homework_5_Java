package Homework_5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exemple_2 {
    public static void main(String[] args) {
        Map<String, String> man = new HashMap<>();
        Scanner iScanner = new Scanner(System.in);
        manConstractor(man, iScanner);
        iScanner.close();
        }

    public static void addPeople(Scanner iScanner, Map<String, String> man){
        String surname = scannerStr("Введите фамилию", iScanner);
        String name = scannerStr("Введите имя", iScanner);
        man.putIfAbsent(surname, name);
        
    }

    public static String scannerStr (String message,Scanner iScanner) {
        System.out.println(message);
        String str = null;
        do{
        str = iScanner.nextLine();
        }while(str.isEmpty());


        return str;
    }

    public static SortedMap<String, Integer>sort(Map<String, String>man){
        SortedMap<String, Integer> sort = new TreeMap<>();
        for(var item : man.entrySet()){
            if (sort.containsKey(item.getValue())){
                int x = sort.get(item.getValue());
                x = x + 1;
                sort.put(item.getValue(), x);
            }
            else{
                sort.put(item.getValue(), 1);
            }
        }

        return sort;
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> sort) {
        Map<String, Integer> sortedMap = sort.entrySet().stream() 
        .sorted(Comparator.comparingInt(e -> -e.getValue())) 
        .collect(Collectors.toMap( 
        Map.Entry::getKey, 
        Map.Entry::getValue, 
        (a, b) -> { throw new AssertionError(); }, 
        LinkedHashMap::new 
        ));  

        return sortedMap;
    }

    public static void sorted(Map<String, String> man){
        SortedMap<String, Integer> sort = sort(man);
        Map<String, Integer> sorted = sortByValue(sort);
        sorted.entrySet().forEach(System.out::println);
    }


    public static void manConstractor(Map<String, String> man, Scanner iScanner){
        while(true){
            String commands = scannerStr("Введите команду для очереди.\n(A - добавить человека в список, S - показать сортированный список, Q - для выхода)", iScanner);
            commands = commands.toUpperCase();
            switch(commands){
                case "A":
                addPeople(iScanner, man);
                manConstractor(man, iScanner);
                case "S":
                sorted(man);
                manConstractor(man, iScanner);
                case "Q":
                break;
            }
        }

    }
}
