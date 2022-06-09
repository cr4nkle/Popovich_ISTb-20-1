package program.gui.tablemodel;

import javax.swing.table.AbstractTableModel;

public abstract class DataModel extends AbstractTableModel {
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
            case 3: return "Цена (руб.)";
            case 4: return "Кол-во (шт)";
        }
        return "";
    }
}
