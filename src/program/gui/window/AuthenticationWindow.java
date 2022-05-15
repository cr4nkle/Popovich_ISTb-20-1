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
    private Container container;

    public AuthenticationWindow(View view){
        setTitle("Аутентификация");
        Font font = new Font("TimesRoman", Font.PLAIN, 25);
        loginLabel = new JLabel("ФИО");
        passwordLabel = new JLabel("Пароль");
        authenticationButton = new JButton("Войти");
        authenticationButton.setFont(font);
        //authenticationButton.setSize(new Dimension(50, 50));
        loginLabel.setFont(font);
        passwordLabel.setFont(font);
        loginField = new JTextField();
        loginField.setFont(font);
        loginField.setPreferredSize(new Dimension(250,30));
        passwordField = new JTextField();
        passwordField.setFont(font);
        passwordField.setPreferredSize(new Dimension(250,30));
        container = new Container();
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets    = new Insets(2, 2, 2, 2);
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        container.add(loginLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(passwordLabel, constraints);

        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(loginField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        container.add(passwordField, constraints);

        add(container, BorderLayout.CENTER);
        add(authenticationButton, BorderLayout.SOUTH);
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
