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
    private JRadioButton maleCheckBox;
    private JRadioButton femaleCheckBox;
    private JButton deleteButton;
    private JButton updateButton;
    private JComboBox departmentComboBox;

    CrudOperations x = new CrudOperations("Students.txt");

    UpdateStudent(Student student){

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleCheckBox);
        genderGroup.add(femaleCheckBox);

        setTitle("Students Editor");
        setContentPane(mainPanel);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        name.setText(student.getFullName());
        id.setText(student.getStudentId());
        gpa.setText(String.valueOf(student.getGpa()));
        age.setText(String.valueOf(student.getAge()));

        String[] departments = {
                "Not Selected",
                "Computer Engineering",
                "Communication Engineering",
                "Electrical Engineering",
                "Mechanical Engineering",
                "Civil Engineering",
                "Industrial Engineering",
                "Architecture",
                "Mechatronics",
                "Biomedical Engineering",
                "Software Engineering",
                "Chemical Engineering",
                "Petroleum Engineering",
        };

        for (String dep : departments) {
            departmentComboBox.addItem(dep);
        }

        departmentComboBox.setSelectedItem(student.getDepartment());

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
                String dep=(String) departmentComboBox.getSelectedItem();
                if ( name.getText().isEmpty() ||
                        age.getText().isEmpty() || dep.equals("Not Selected") ||
                        gpa.getText().isEmpty() ) {

                    JOptionPane.showMessageDialog(null, "Please fill all the fields .");
                    return;
                }

                int tempAge;
                double tempGpa;
                try{
                    tempAge = Integer.parseInt(age.getText());
                    tempGpa = Double.parseDouble(gpa.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter age / gpa as  a numeric value.");
                    return;
                }

                if(tempGpa < 0 || tempGpa > 4) {
                    JOptionPane.showMessageDialog(null, "Please enter a GPA value between 0 and 4.");
                    return;
                }
                if(tempAge < 16 || tempAge > 100){ //16 as least age for a college student
                    JOptionPane.showMessageDialog(null, "Please enter age value between 16 and 100.");
                    return;
                }



                if(!Validation.isValidName(name.getText())){
                    JOptionPane.showMessageDialog(null, "Please enter a valid name.");
                    return;
                }
                Student sNew =new Student(id.getText(), name.getText(), Integer.parseInt(age.getText()),g,dep,Double.parseDouble(gpa.getText()));
                x.updateStudent(id.getText(),sNew);
                JOptionPane.showMessageDialog(null, "Student updated successfully!");
                dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.deleteStudent(student);
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    x.deleteStudent(student);
                    JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                    dispose();
                }
            }
        });
    }



}
