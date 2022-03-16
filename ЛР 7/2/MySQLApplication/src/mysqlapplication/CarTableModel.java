package mysqlapplication;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CarTableModel extends AbstractTableModel {

    private int column = 4;
    private int rownum;

    private String[] colNames = {"CarID", "Name", "Type", "Vendor"};
    private ArrayList<String[]> ResultSets;

    public CarTableModel(ResultSet rs) {
        ResultSets = new ArrayList<>();
        try {
            while (rs.next()) {
                String[] row = {rs.getString("CarID"), rs.getString("Name"), rs.getString("Type"), rs.getString("Vendor")};
                ResultSets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Exception in CarTableModel");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = ResultSets.get(rowIndex);
        return row[columnIndex];
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
    public String getColumnName(int param) {
        return colNames[param];
    }
}
