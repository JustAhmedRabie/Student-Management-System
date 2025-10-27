package student.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudentForm extends javax.swing.JFrame {
    private JPanel SearchContainer;
    private JTextField studentId;
    private JButton searchButton;
    private JButton returnButton;


    private CrudOperations crud = new CrudOperations("Students.txt");

    public SearchStudentForm() {
        setVisible(true);
        setSize(200,200);
        setContentPane(SearchContainer);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String id = studentId.getText();
             id=id.trim();

             if(id.isEmpty()){
                 JOptionPane.showMessageDialog(SearchContainer,"Please enter Student ID");
                 return;
             }

             if(!Validation.isValidId(id)){
                 JOptionPane.showMessageDialog(SearchContainer,"Invalid Student ID");
                 return;
             }

             Student student = crud.searchStudent(id);

             if(student==null){
                 JOptionPane.showMessageDialog(SearchContainer,id +" Student ID Does not exist");
                 return;
             }

             String line[] = student.lineRepresentation().split(",");
             new SearchStudentData(line);



            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeForm();

            }
        });
    }
}
