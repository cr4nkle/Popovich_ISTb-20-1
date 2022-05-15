package program.gui.window;

import program.gui.window.View;

import javax.swing.*;
import java.awt.*;

public class AuthenticationWindow extends JFrame {
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JTextField loginField;
    private JTextField passwordField;
    private JButton authenticationButton;

    public AuthenticationWindow(View view){
        setTitle("Аутентификация");
        loginLabel = new JLabel("ФИО");
        passwordLabel = new JLabel("Пароль");
        authenticationButton = new JButton("Войти");
        Font font = new Font("TimesRoman", Font.PLAIN, 25);
        loginLabel.setFont(font);
        passwordLabel.setFont(font);
        loginField = new JTextField();
        loginField.setFont(font);
        loginField.setPreferredSize(new Dimension(250,30));
        passwordField = new JTextField();
        passwordField.setFont(font);
        passwordField.setPreferredSize(new Dimension(250,30));
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets    = new Insets(2, 2, 2, 2);
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(loginLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(passwordLabel, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 2;
        add(authenticationButton, constraints);

        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(loginField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(passwordField, constraints);
        pack();
        setVisible(true);

        setLocationRelativeTo(view);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JButton getAuthenticationButton() {
        return authenticationButton;
    }
}
