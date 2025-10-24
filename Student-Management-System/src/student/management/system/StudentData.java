package student.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentData extends JFrame {
    private JTable table1;
    private JPanel mainPanel;
    private JButton returnHomePageButton;
    private DefaultTableModel model;

    StudentData(){
        setTitle("Students Table");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        String[] columns = {"ID", "Name", "Age", "Gender", "Major", "GPA"};

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(model);
        StudentDatabase studentDatabase = new StudentDatabase("Student-Management-System/Students.txt");
        studentDatabase.readFromFile();

        table1.setRowHeight(30);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);

        for (Record x :studentDatabase.returnAllRecords()){
        String y=x.lineRepresentation();
        String[] data = y.split(",");
        model.addRow(data);
        }

        returnHomePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeForm();
            }
        });
    }


}
