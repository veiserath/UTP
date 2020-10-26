import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class CountryTable {

    String countriesFileName;
    String[] columnNames;
    List<String> countryNames;
    List<Integer> populations;
    List<String> capitalNames;
    List<ImageIcon> flags;


    public CountryTable(String countriesFileName) {
        this.countryNames = new LinkedList<>();
        this.populations = new LinkedList<>();
        this.capitalNames = new LinkedList<>();
        this.flags = new LinkedList<>();
        this.countriesFileName = countriesFileName;
        readFile();


    }

    public JTable create() {
        MyTableModel myTableModel = new MyTableModel(this);
        JTable jTable = new JTable(myTableModel);
        MyCellRenderer myCellRenderer = new MyCellRenderer();
        jTable.setDefaultRenderer(Integer.class, myCellRenderer);
        return jTable;
    }

    public void readFile() {
        String line;
        boolean isFirstRow = true;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(countriesFileName));
            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    columnNames = line.split("\\t");
                    isFirstRow = false;
                } else {
                    String[] splitLine = line.split("\\t");
                    countryNames.add(splitLine[0]);
                    capitalNames.add(splitLine[1]);
                    populations.add(Integer.parseInt(splitLine[2]));
                    flags.add(addFlag(splitLine[0]));
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon addFlag(String countryName) {
        

        countryName = countryName.replaceAll(" ", "-");
        countryName = "data/flags/" + countryName + "-flag.png";
        ImageIcon imageIcon = new ImageIcon(countryName);
        return imageIcon;
    }


}
