import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {


    CountryTable countryTable;


    MyTableModel(CountryTable countryTable) {
        this.countryTable = countryTable;

    }

    @Override
    public String getColumnName(int column) {
        return countryTable.columnNames[column];
    }

    @Override
    public int getRowCount() {
        return countryTable.flags.size();
    }

    @Override
    public int getColumnCount() {
        return countryTable.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return countryTable.countryNames.get(rowIndex);
            case 1:
                return countryTable.capitalNames.get(rowIndex);
            case 2:
                return countryTable.populations.get(rowIndex);
            case 3:
                return countryTable.flags.get(rowIndex);
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return ImageIcon.class;
        }
        return null;

    }
}
