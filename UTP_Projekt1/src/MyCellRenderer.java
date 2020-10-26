import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MyCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBackground(table.getBackground());

        if (isSelected) {
            setBackground(table.getSelectionBackground());
        }
        try {
            int number = (Integer) value;
            if (number > 20000)
                setBackground(Color.RED);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return this;
    }
}
