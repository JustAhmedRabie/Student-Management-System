package student.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 290);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("12345")) {
                    dispose();
                    new HomeForm();
                } else if(username.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter Your username!");
                }
                else if (password.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter Your Password!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });
    }


}
