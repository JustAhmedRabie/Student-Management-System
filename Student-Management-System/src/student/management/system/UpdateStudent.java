package student.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudent extends JFrame {
    private JPanel mainPanel;
    private JTextField id;
    private JTextField gpa;
    private JTextField name;
    private JTextField age;
    private JTextField dep;
    private JCheckBox maleCheckBox;
    private JCheckBox femaleCheckBox;
    private JButton deleteButton;
    private JButton updateButton;

    CrudOperations x = new CrudOperations("Students.txt");

    UpdateStudent(Student student){

        setTitle("Students Editor");
        setContentPane(mainPanel);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        name.setText(student.getFullName());
        id.setText(student.getStudentId());
        gpa.setText(String.valueOf(student.getGpa()));
        age.setText(String.valueOf(student.getAge()));
        dep.setText(student.getDepartment());
        if (student.getGender().equalsIgnoreCase("Male")) {
            maleCheckBox.setSelected(true);
            femaleCheckBox.setSelected(false);
        } else {
            femaleCheckBox.setSelected(true);
            maleCheckBox.setSelected(false);
        }


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String g;
                if (maleCheckBox.isSelected()) {
                     g ="Male";
                } else {
                     g ="Female";
                }
                Student sNew =new Student(id.getText(), name.getText(), Integer.parseInt(age.getText()),g,dep.getText(),Double.parseDouble(gpa.getText()));
                x.updateStudent(id.getText(),sNew);

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.deleteStudent(student);
            }
        });
    }



}
