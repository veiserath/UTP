package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        zadania tablice
//        zad 1
        System.out.println("Tablice");
        System.out.println("zadanie nr 1: " + zadanie1());
//        zad 2
        System.out.println("zadanie nr 2: ");
        int[] longerTable = zadanie2(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int i = 0; i < longerTable.length; i++){
            System.out.print(longerTable[i] + " ");
        }
        System.out.println();
        System.out.println("zadanie nr 3: ");
        int[] zadanie3Table = zadanie3(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int i = 0; i < zadanie3Table.length; i++){
            System.out.print(zadanie3Table[i] + " ");
        }
        System.out.println();
        System.out.println("zadanie nr 4: ");
        int[] zadanie4Table = zadanie4(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int i = 0; i < zadanie4Table.length; i++){
            System.out.print(zadanie4Table[i] + " ");
        }
        System.out.println();

//        kolekcje
        System.out.println("Kolekcje");
        System.out.println("Zadanie nr 1: ");
        LinkedHashSet<Integer> losowanie = zadanie1Kolekcje();
        System.out.println(losowanie);


        System.out.println("Zadanie nr 2: ");
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.addAll(Arrays.asList(6,1,2,4,4,4,3,3));
        HashMap<Integer,Integer> occurences = new HashMap<>();

        for (Integer number : numbers){
            if (occurences.containsKey(number)){
                occurences.put(number,occurences.get(number) + 1);
            }
            else {
                occurences.put(number,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : occurences.entrySet()){
            if (entry.getValue() != 1){
                System.out.println(entry.getKey() + " wystepuje " + entry.getValue() + " razy.");
            }
            else {
                System.out.println(entry.getKey() + " wystepuje " + entry.getValue() + " raz.");
            }

        }

        System.out.println("Zadanie nr 3: ");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj slowko po polsku: ");
//        String wordInPolish = scanner.nextLine();
//        HashMap<String,String> dictionary = new HashMap<>();
//        dictionary.put("Matka","Mother");
//        dictionary.put("Ojciec","Father");
//        dictionary.put("Dziadek","Grandfather");
//        dictionary.put("Babcia","Grandmother");
//        dictionary.put("Ciocia","Aunt");
//        dictionary.put("Wujek","Uncle");
//
//        if (dictionary.containsKey(wordInPolish))
//            System.out.println("Slowko po angielsku: " + dictionary.get(wordInPolish));
//        else
//            System.out.println("Nie ma tego slowa w slowniku");


        System.out.println("Zadanie nr 4: ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę do konwersji: ");
        int wholeNumber = scanner.nextInt();
        String binaryNumber = Integer.toBinaryString(wholeNumber);
        System.out.println(binaryNumber);

    }
    public static int zadanie1(){
        int[] table = {1,2,3};
        int sum = 0;
        for (int i = 0; i < table.length; ++i){
            sum+=table[i];
        }
        return sum;
    }
    public static int[] zadanie2(int inputTable[]){
        int[] longerTable = new int[inputTable.length*2];
        longerTable[longerTable.length-1] = inputTable[inputTable.length-1];
        return longerTable;
    }
    public static int[] zadanie3(int[] inputTable){
        int first = inputTable[0];
        int last = inputTable[inputTable.length-1];
        int max = 0;
        if (first > last){
            max = first;
        }
        else {
            max = last;
        }
        int[] outputTable = inputTable;
        for (int i = 0; i < outputTable.length; ++i){
            outputTable[i] = max;
        }
        return outputTable;

    }
    public static int[] zadanie4(int[] inputTable){
        int[] outputTable = new int[inputTable.length];
        int indexOfOutputTable = inputTable.length - 1;
        for (int i = 0; i < inputTable.length; ++i){
            outputTable[indexOfOutputTable] = inputTable[i];
            --indexOfOutputTable;
        }
        return outputTable;
    }
    public static LinkedHashSet<Integer> zadanie1Kolekcje(){
        Random random = new Random();
        LinkedHashSet<Integer> losowanie = new LinkedHashSet<>();
        while (losowanie.size() < 6){
            int randomNumber = random.nextInt(49 - 1 + 1) + 1;
            losowanie.add(randomNumber);
        }
        return losowanie;
    }
}
