package program.gui.tablemodel;

import program.model.Product;
import program.model.Store;

public class BasketTableModel extends DataModel {
    private Store store = Store.getInstance();

    @Override
    public Object getValueAt(int i, int i1) {
        String result = "";
        Product p = store.getProduct(i);
        switch (i1) {
            case 0:
                result = Integer.toString(i + 1);
                break;
            case 1:
                result = Integer.toString(p.getCode());
                break;
            case 2:
                result = p.getName();
                break;
            case 3:
                result = Integer.toString(p.getPrice());
                break;
            case 4:
                result = Integer.toString(p.getQuantity());
                break;
        }
        return result;
    }

    @Override
    public int getRowCount() {
        return store.getProductListSize();
    }

    @Override
    public int getColumnCount() {
        return super.getColumnCount();
    }

    public void change(){
        fireTableDataChanged();
    }
}
