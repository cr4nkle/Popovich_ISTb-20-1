package program.model;

import javax.swing.table.AbstractTableModel;

public class DataModel extends AbstractTableModel {
    public static final int COL_COUNT = 5;
    //хранить размер столбцов для Table
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return COL_COUNT;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return null;
    }

    public String getColumnName(int column){
        switch(column){
            case 0: return "№";
            case 1: return "Код товара";
            case 2: return "Наименование товара";
            case 3: return "Цена";
            case 4: return "Кол-во";
        }
        return "";
    }
}
