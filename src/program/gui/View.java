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
    private JTextField infoField;

    public View(){
        Dimension firstDimension = new Dimension(100, 100);
        Dimension secondDimension = new Dimension(200, 100);
        Dimension thirdDimension = new Dimension(400, 200);

        Font font = new Font("TimesRoman", Font.PLAIN, 40);

        gridBagContainer = new Container();
        gridBagContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        gridBagContainer.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets    = new Insets(2, 2, 2, 2);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridy   = 0  ;

        button1 = new JButton("1");
        button1.setFont(font);
        button1.setPreferredSize(firstDimension);
        constraints.gridx = 4;
        constraints.gridy = 0;
        gridBagContainer.add(button1,constraints);

        button2 = new JButton("2");
        button2.setFont(font);
        button2.setPreferredSize(firstDimension);
        constraints.gridx = 5;
        constraints.gridy = 0;
        gridBagContainer.add(button2,constraints);

        button3 = new JButton("3");
        button3.setFont(font);
        button3.setPreferredSize(firstDimension);
        constraints.gridx = 6;
        constraints.gridy = 0;
        gridBagContainer.add(button3,constraints);

        cancelButton = new JButton("Отмена");
        cancelButton.setFont(font);
        cancelButton.setPreferredSize(secondDimension);
        constraints.gridx = 0;
        constraints.gridy = 1;
        gridBagContainer.add(cancelButton,constraints);

        quantityButton = new JButton("Кол-во");
        quantityButton.setFont(font);
        quantityButton.setPreferredSize(secondDimension);
        constraints.gridx = 1;
        constraints.gridy = 1;
        gridBagContainer.add(quantityButton,constraints);

        barcodeButton = new JButton("Шт.код");
        barcodeButton.setFont(font);
        barcodeButton.setPreferredSize(secondDimension);
        constraints.gridx = 2;
        constraints.gridy = 1;
        gridBagContainer.add(barcodeButton,constraints);

        resultButton = new JButton("Итог");
        resultButton.setFont(font);
        resultButton.setPreferredSize(secondDimension);
        constraints.gridx = 3;
        constraints.gridy = 1;
        gridBagContainer.add(resultButton,constraints);

        button4 = new JButton("4");
        button4.setFont(font);
        button4.setPreferredSize(firstDimension);
        constraints.gridx = 4;
        constraints.gridy = 1;
        gridBagContainer.add(button4,constraints);

        button5 = new JButton("5");
        button5.setFont(font);
        button5.setPreferredSize(firstDimension);
        constraints.gridx = 5;
        constraints.gridy = 1;
        gridBagContainer.add(button5,constraints);

        button6 = new JButton("6");
        button6.setFont(font);
        button6.setPreferredSize(firstDimension);
        constraints.gridx = 6;
        constraints.gridy = 1;
        gridBagContainer.add(button6,constraints);

        codeButton = new JButton("Код");
        codeButton.setFont(font);
        codeButton.setPreferredSize(secondDimension);
        constraints.gridx = 2;
        constraints.gridy = 2;
        gridBagContainer.add(codeButton,constraints);

        discountButton = new JButton("Скидка");
        discountButton.setFont(font);
        discountButton.setPreferredSize(secondDimension);
        constraints.gridx = 3;
        constraints.gridy = 2;
        gridBagContainer.add(discountButton,constraints);

        button7 = new JButton("7");
        button7.setFont(font);
        button7.setPreferredSize(firstDimension);
        constraints.gridx = 4;
        constraints.gridy = 2;
        gridBagContainer.add(button7,constraints);

        button8 = new JButton("8");
        button8.setFont(font);
        button8.setPreferredSize(firstDimension);
        constraints.gridx = 5;
        constraints.gridy = 2;
        gridBagContainer.add(button8,constraints);

        button9 = new JButton("9");
        button9.setFont(font);
        button9.setPreferredSize(firstDimension);
        constraints.gridx = 6;
        constraints.gridy = 2;
        gridBagContainer.add(button9,constraints);

        exitButton = new JButton("Выход");
        exitButton.setFont(font);
        exitButton.setPreferredSize(secondDimension);
        constraints.gridx = 2;
        constraints.gridy = 3;
        gridBagContainer.add(exitButton,constraints);

        endButton = new JButton("Закрыть"+"/n"+"смену");
        endButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        endButton.setPreferredSize(secondDimension);
        constraints.gridx = 3;
        constraints.gridy = 3;
        gridBagContainer.add(endButton,constraints);

        dotButton = new JButton(".");
        dotButton.setFont(font);
        dotButton.setPreferredSize(firstDimension);
        constraints.gridx = 4;
        constraints.gridy = 3;
        gridBagContainer.add(dotButton,constraints);

        zeroButton = new JButton("0");
        zeroButton.setFont(font);
        zeroButton.setPreferredSize(firstDimension);
        constraints.gridx = 5;
        constraints.gridy = 3;
        gridBagContainer.add(zeroButton,constraints);

        doubleZeroButton = new JButton("00");
        doubleZeroButton.setFont(font);
        doubleZeroButton.setPreferredSize(firstDimension);
        constraints.gridx = 6;
        constraints.gridy = 3;
        gridBagContainer.add(doubleZeroButton,constraints);

        infoField = new JTextField();
        infoField.setFont(font);
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        gridBagContainer.add(infoField,constraints);

        payButton = new JButton("Оплата");
        payButton.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        payButton.setPreferredSize(secondDimension);
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.gridx = 0;
        constraints.gridy = 2;
        gridBagContainer.add(payButton,constraints);

        add(gridBagContainer, BorderLayout.SOUTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1112,406));

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton5() {
        return button5;
    }

    public JButton getButton6() {
        return button6;
    }

    public JButton getButton8() {
        return button8;
    }

    public JButton getButton7() {
        return button7;
    }

    public JButton getButton9() {
        return button9;
    }

    public JButton getBarcodeButton() {
        return barcodeButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getCodeButton() {
        return codeButton;
    }

    public JButton getDiscountButton() {
        return discountButton;
    }

    public JButton getDotButton() {
        return dotButton;
    }

    public JButton getDoubleZeroButton() {
        return doubleZeroButton;
    }

    public JButton getEndButton() {
        return endButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getPayButton() {
        return payButton;
    }

    public JButton getQuantityButton() {
        return quantityButton;
    }

    public JButton getResultButton() {
        return resultButton;
    }

    public JButton getZeroButton() {
        return zeroButton;
    }

    public JTextField getInfoField() {
        return infoField;
    }

    public JTable getTable() {
        return table;
    }
}
