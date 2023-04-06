package Homework_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exemple_1 {
    public static void main(String[] args) {
        Map<String,String> man = new HashMap<>();
        Scanner iScanner = new Scanner(System.in);
        turnConstractor(man, iScanner);
    }

    public static String scannerStr (String message,Scanner iScanner) {
        System.out.println(message);
        String str = null;
        do{
        str = iScanner.nextLine();
        }while(str.isEmpty());


        return str;
    }

    public static int scannerInt (String message, Scanner iScanner) {
        System.out.println(message);
        int x = iScanner.nextInt();

        return x;
    }

    public static void addPeople(Scanner iScanner, Map<String, String> man){
        String name = scannerStr("Введите имя", iScanner);
        String number = scannerStr("Введите номер", iScanner);
        if (man.containsKey(name)){
            String x = man.get(name);
            x = x + ", " + number;
            man.put(name, x);
        }
        else{
            man.put(name, number);
        }
        
    }

    public static void show(Scanner iScanner, Map<String, String> man){
        String name = scannerStr("Введите имя", iScanner);
        System.out.println(man.get(name));
    }

    public static void turnConstractor(Map<String, String> man, Scanner iScanner){
        while(true){
            String commands = scannerStr("Введите команду для очереди.\n(A - добавить человека в список, S - показать людей в списке, Q - для выхода)", iScanner);
            commands = commands.toUpperCase();
            switch(commands){
                case "A":
                addPeople(iScanner, man);
                turnConstractor(man, iScanner);
                case "S":
                show(iScanner, man);
                turnConstractor(man, iScanner);
                case "Q":
                break;
            }
        }

    }
}
