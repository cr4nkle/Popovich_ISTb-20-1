package program.gui.window;

import javax.swing.*;
import java.awt.*;

public class ReceiptOutputWindow extends JFrame {
    private JTextArea receiptInfoArea;
    private JButton okButton;

    public ReceiptOutputWindow(){
        setTitle("Чек");
        receiptInfoArea = new JTextArea(30, 20);
        okButton = new JButton("ОК");
        okButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(receiptInfoArea, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);
        setVisible(true);
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JTextArea getReceiptInfoArea() {
        return receiptInfoArea;
    }
}
