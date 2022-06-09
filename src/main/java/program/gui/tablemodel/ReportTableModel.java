package program.gui.tablemodel;

import program.database.DataRepository;
import program.model.Product;
import program.model.Report;
import program.model.Store;

import javax.swing.table.AbstractTableModel;

public class ReportTableModel extends AbstractTableModel {
    private DataRepository database = DataRepository.getInstance();
    public static final int COL_COUNT = 5;
    @Override
    public int getRowCount() {
        return database.getReportListSize();
    }

    @Override
    public int getColumnCount() {
        return COL_COUNT;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        String result = "";
        Report r = database.getReport(i);
        switch (i1) {
            case 0:
                result = r.getCashierName();
                break;
            case 1:
                result = r.getProductName();
                break;
            case 2:
                result = Integer.toString(r.getPrice());
                break;
            case 3:
                result = Integer.toString(r.getQuantity());
                break;
            case 4:
                result = Integer.toString(r.getTotalPrice());
                break;
        }
        return result;
    }

    public String getColumnName(int column){
        switch(column){
            case 0: return "Имя кассира";
            case 1: return "Наименование товара";
            case 2: return "Цена (руб.)";
            case 3: return "Кол-во (шт)";
            case 4: return "Итог";
        }
        return "";
    }
}
