package sqlapplication;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DormitoryTableModel extends AbstractTableModel {

    private int column = 2;
    private int rownum;

    private String[] colNames = {"Номер", "Адрес"};
    private ArrayList<String[]> ResultSets;

    public DormitoryTableModel(ResultSet rs) {
        ResultSets = new ArrayList<>();
        try {
            while (rs.next()) {
                String[] row = {rs.getString("Номер"), rs.getString("Адрес")};
                ResultSets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Exception in DormitoryTableModel");
        }
    }

    @Override
    public int getRowCount() {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = ResultSets.get(rowIndex);
        return row[columnIndex];
    }

    @Override
    public String getColumnName(int param) {
        return colNames[param];
    }
}
