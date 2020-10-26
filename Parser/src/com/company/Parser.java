package com.company;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {

    private static final String SAMPLE_CSV_FILE_PATH = "data/table-1.csv";

    Parser(){
        try {
            createFile();
            FileWriter myWriter = new FileWriter("data/parsed.txt");
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            int i = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
//                population is given as capital population, need to convert to total population using last column
                if (i > 0){
                    String populationOfCapitalAsString = splitter(nextRecord[3],"\\[");
                    populationOfCapitalAsString = populationOfCapitalAsString.replaceAll(",","");
                    long populationOfCapital = Long.parseLong(populationOfCapitalAsString);

                    double percentage = Double.parseDouble(splitter(nextRecord[5],"%"));
                    double totalCountryPopulation = (double) (100*populationOfCapital)/percentage;
                    totalCountryPopulation = totalCountryPopulation/1000;
                    long totalCountryPopulationInt = (long) totalCountryPopulation;
                    myWriter.write(nextRecord[1] + "\t" + nextRecord[2] + "\t" + totalCountryPopulationInt + "\n");
                }
                else{
                    myWriter.write("Name\tCapital\tPopulation\tFlag\n");
                }
                i++;
            }
            myWriter.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public void createFile(){
        File file = new File("data/parsed.txt");
        try {
            if (file.createNewFile()){
                System.out.println("File created.");
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String splitter(String toBeSplitted, String delimiter){
        String[] splitted = toBeSplitted.split(delimiter);
        return splitted[0];
    }

}
