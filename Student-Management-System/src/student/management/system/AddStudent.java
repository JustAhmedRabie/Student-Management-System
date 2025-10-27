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

    private CrudOperations x = new CrudOperations("Students.txt");

   AddStudent() {
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleCheckBox);
        genderGroup.add(femaleCheckBox);
        setTitle("Students");
        setContentPane(mainPanel);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (id.getText().isEmpty() || name.getText().isEmpty() ||
                        age.getText().isEmpty() || department.getText().isEmpty() ||
                        gpa.getText().isEmpty() || (!maleCheckBox.isSelected() && !femaleCheckBox.isSelected())) {

                    JOptionPane.showMessageDialog(null, "Please fill all fields and select a gender.");
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
                if(!Validation.isValidId(id.getText())){
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                    return;
                }

                if(x.searchStudent(id.getText()) == null){ //Student with that id does not exist
                    ; // do nothing
                }
                else{
                    JOptionPane.showMessageDialog(null, "Student ID already exists.");
                    return;
                }

                if(!Validation.isValidName(name.getText())){
                    JOptionPane.showMessageDialog(null, "Please enter a valid name.");
                    return;
                }

                String g;
                if (maleCheckBox.isSelected()) {
                    g = "Male";
                } else {
                    g = "Female";
                }
                Student sNew = new Student(id.getText().trim(), name.getText().trim(), tempAge, g, department.getText().trim(),tempGpa);
                x.addStudent(sNew);
                JOptionPane.showMessageDialog(null, "Student added successfully!");
                dispose();
                new HomeForm();

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

        id = new JTextField();
        name = new JTextField();
        gpa = new JTextField();
        department = new JTextField();
        age = new JTextField();
        maleCheckBox = new JRadioButton("Male");
        femaleCheckBox = new JRadioButton("Female");
    }


}
