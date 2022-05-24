package program.gui.window;

import javax.swing.*;
import java.awt.*;

public class BarcodeInputWindow extends JFrame {
    private JTextField inputField;
    private JButton enterButton;

    public BarcodeInputWindow(){
        setTitle("Штрих-код");
        setLayout(new FlowLayout());
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(400, 25));
        enterButton = new JButton("Ввести");
        add(inputField);
        add(enterButton);
        setVisible(true);
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
