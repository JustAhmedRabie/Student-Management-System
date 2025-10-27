package student.management.system;

import javax.swing.*;

public class SearchStudentData extends javax.swing.JFrame {
    private JPanel studentData;
    private JTextField nameField;
    private JTextField idField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField deptField;
    private JTextField gpaField;


    public SearchStudentData(String [] sData) {



        setVisible(true);
        setSize(500,300);
        setContentPane(studentData);
        setLocationRelativeTo(null);

        idField.setEditable(false);
        nameField.setEditable(false);
        ageField.setEditable(false);
        genderField.setEditable(false);
        deptField.setEditable(false);
        gpaField.setEditable(false);

        idField.setText(sData[0]);
        nameField.setText(sData[1]);
        ageField.setText(sData[2]);
        genderField.setText(sData[3]);
        deptField.setText(sData[4]);
        gpaField.setText(sData[5]);


    }
}
