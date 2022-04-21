package program.gui;

import program.tablemodel.BasketTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public void execute(View view){
        view.getTable().setModel(new BasketTableModel());
    }
}
