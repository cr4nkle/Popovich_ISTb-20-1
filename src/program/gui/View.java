package program.gui;

import program.tablemodel.BasketTableModel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton dotButton;
    private JButton zeroButton;
    private JButton doubleZeroButton;
    private JButton cancelButton;
    private JButton quantityButton;
    private JButton exitButton;
    private JButton payButton;
    private JButton resultButton;
    private JButton endButton;
    private JButton barcodeButton;
    private JButton codeButton;
    private JButton discountButton;
    private JScrollPane scrollPane;
    private JTable table;
    private BasketTableModel basketTableModel;
    private Container gridBagContainer;

    public View(){
        Dimension firstDimension = new Dimension(100, 100);
        Dimension secondDimension = new Dimension(205, 100);
        Dimension thirdDimension = new Dimension(100, 100);
    }
}
