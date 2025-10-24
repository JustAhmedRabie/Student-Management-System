package student.management.system;

import javax.swing.*;

public class HomeForm extends JFrame{
    private JPanel mainPanel;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JButton VIEWButton;
    private JButton ADDButton;

    public HomeForm(){
        setTitle("Student Management System");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
