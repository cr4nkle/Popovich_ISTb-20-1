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
    private Container gridBagContainer2;

    public View(){
        Dimension firstDimension = new Dimension(100, 100);
        Dimension secondDimension = new Dimension(200, 100);
        Dimension thirdDimension = new Dimension(400, 200);

        gridBagContainer = new Container();
        gridBagContainer2 = new Container();
        gridBagContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        gridBagContainer2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        gridBagContainer.setLayout(new GridBagLayout());
        gridBagContainer2.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // По умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridy   = 0  ;  // нулевая ячейка таблицы по вертикали

        codeButton = new JButton("Код");
        codeButton.setMinimumSize(secondDimension);
        //constraints.insets    = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        gridBagContainer2.add(codeButton, constraints);

        exitButton = new JButton("Выход");
        exitButton.setMinimumSize(secondDimension);
        constraints.gridx = 0;
        constraints.gridy = 1;
        gridBagContainer2.add(exitButton, constraints);

        discountButton = new JButton("Скидка");
        discountButton.setMinimumSize(secondDimension);
        constraints.gridx = 1;
        constraints.gridy = 0;
        gridBagContainer2.add(discountButton, constraints);

        endButton = new JButton("Закр.смены");
        endButton.setMinimumSize(secondDimension);
        constraints.gridx = 1;
        constraints.gridy = 1;
        gridBagContainer2.add(endButton, constraints);

        button7 = new JButton("7");
        button7.setMinimumSize(firstDimension);
        constraints.gridx = 2;
        constraints.gridy = 0;
        gridBagContainer2.add(button7, constraints);

        dotButton = new JButton(".");
        dotButton.setMinimumSize(firstDimension);
        constraints.gridx = 2;
        constraints.gridy = 1;
        gridBagContainer2.add(dotButton, constraints);

        button8 = new JButton("8");
        button8.setMinimumSize(firstDimension);
        constraints.gridx = 3;
        constraints.gridy = 0;
        gridBagContainer2.add(button8, constraints);

        zeroButton = new JButton("0");
        zeroButton.setMinimumSize(firstDimension);
        constraints.gridx = 3;
        constraints.gridy = 1;
        gridBagContainer2.add(zeroButton, constraints);

        button9 = new JButton("9");
        button9.setMinimumSize(firstDimension);
        constraints.gridx = 4;
        constraints.gridy = 0;
        gridBagContainer2.add(button9, constraints);

        doubleZeroButton = new JButton("00");
        doubleZeroButton.setMinimumSize(firstDimension);
        constraints.gridx = 4;
        constraints.gridy = 1;
        gridBagContainer2.add(doubleZeroButton, constraints);

        button1 = new JButton("1");
        button1.setMinimumSize(secondDimension);
        constraints.gridx = 0;
        constraints.gridy = 0;
        gridBagContainer.add(button1, constraints);

        button2 = new JButton("2");
        button2.setMinimumSize(secondDimension);
        constraints.gridx = 1;
        constraints.gridy = 0;
        gridBagContainer.add(button2, constraints);

        button3 = new JButton("3");
        button3.setMinimumSize(secondDimension);
        constraints.gridx = 2;
        constraints.gridy = 0;
        gridBagContainer.add(button3, constraints);


        constraints.ipadx = 45;
        constraints.gridwidth = 5;
        constraints.gridx = 2;
        constraints.gridy = 1;
        gridBagContainer.add(gridBagContainer2, constraints);

        button4 = new JButton("4");
        button4.setMinimumSize(secondDimension);
        constraints.gridx = 3;
        constraints.gridy = 0;
        gridBagContainer.add(button4, constraints);

        payButton = new JButton("Оплата");
        payButton.setMinimumSize(thirdDimension);
        constraints.ipady     = 45;   // кнопка высокая
        constraints.weightx   = 0.0;
        constraints.gridwidth = 2;    // размер кнопки в две ячейки
        constraints.gridx     = 0;    // нулевая ячейка по горизонтали
        constraints.gridy     = 1;    // первая ячейка по вертикали
        gridBagContainer.add(payButton, constraints);







        add(gridBagContainer);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
