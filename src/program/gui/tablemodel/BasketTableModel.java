package program.gui.tablemodel;

public class BasketTableModel extends DataModel {
    // добавить класс со списком
    @Override
    public Object getValueAt(int i, int i1) {
        String result = "";

        switch (i1) {
            case 0:
                result = "1";
                break;
            case 1:
                result = "sergey";
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
}
