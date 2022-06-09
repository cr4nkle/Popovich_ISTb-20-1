package program.gui.window;

import javax.swing.*;
import java.awt.*;

public class ReceiptOutputWindow extends JFrame {
    private JTextArea receiptInfoArea;
    private JScrollPane scrollPane;
    private JButton okButton;

    public ReceiptOutputWindow(){
        setTitle("Чек");
        receiptInfoArea = new JTextArea(20, 20);
        receiptInfoArea.setFont(new Font("Courier New", Font.ITALIC, 20));
        receiptInfoArea.setEditable(false);
        okButton = new JButton("ОК");
        okButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        scrollPane = new JScrollPane(receiptInfoArea);
        add(scrollPane, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JTextArea getReceiptInfoArea() {
        return receiptInfoArea;
    }

    public void setReceiptText(String text){
        this.receiptInfoArea.setText(text);
    }
}
