package student.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame {
    private JTextField id;
    private JTextField name;
    private JTextField gpa;
    private JTextField department;
    private JTextField age;
    private JRadioButton femaleCheckBox;
    private JRadioButton maleCheckBox;
    private JButton addButton;
    private JButton homeButton;
    private JPanel mainPanel;

    CrudOperations x = new CrudOperations("Students.txt");

   AddStudent() {
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleCheckBox);
        genderGroup.add(femaleCheckBox);
        setTitle("Students");
        setContentPane(mainPanel);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String g;
                if (maleCheckBox.isSelected()) {
                    g = "Male";
                } else {
                    g = "Female";
                }
                Student sNew = new Student(id.getText(), name.getText(), Integer.parseInt(age.getText()), g, department.getText(), Double.parseDouble(gpa.getText()));
                x.addStudent(sNew);
                JOptionPane.showMessageDialog(null, "Student added successfully!");
                dispose();
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeForm();
            }
        });
    }

    private void createUIComponents() {
        // Example of manual initialization
        id = new JTextField();
        name = new JTextField();
        gpa = new JTextField();
        department = new JTextField();
        age = new JTextField();
        maleCheckBox = new JRadioButton("Male");
        femaleCheckBox = new JRadioButton("Female");
    }


}
