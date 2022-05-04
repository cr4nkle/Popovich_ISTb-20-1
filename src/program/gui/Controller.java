package program.gui;

import program.tablemodel.BasketTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private int buttonFlag;
    private boolean pressFlag = false;
    private String infoText = "";
    public void execute(View view){
        view.getTable().setModel(new BasketTableModel());
        view.getCodeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "Введите код";
                pressFlag = true;
                view.getInfoField().setText(infoText);
            }
        });
//запихнуть всё в список, посмотреть как узнать какая кнопка в списке была нажата
        view.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(pressFlag){
                    infoText = "";
                    pressFlag = false;
                }
                buttonFlag = 1;
                infoText += buttonFlag;
                System.out.println();
                view.getInfoField().setText(infoText);
            }
        });

        view.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(pressFlag){
                    infoText = "";
                    pressFlag = false;
                }
                buttonFlag = 2;
                infoText += buttonFlag;
                view.getInfoField().setText(infoText);
            }
        });

        view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getCashierField().setText(view.getInfoField().getText());
            }
        });

        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                infoText = "";
                view.getInfoField().setText(infoText);
            }
        });

    }
}
