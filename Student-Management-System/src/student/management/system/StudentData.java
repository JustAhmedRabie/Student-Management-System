package student.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentData extends JFrame {
    private JTable table1;
    private JPanel mainPanel;
    private JButton returnHomePageButton;
    private JTextArea searchField;
    private JButton searchButton;
    private JButton reloadButton;
    private DefaultTableModel model;

    CrudOperations x = new CrudOperations("Students.txt");

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
        table1.setRowHeight(30);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);

        for (Record i :x.returnAllStudents()){
            String y= i.lineRepresentation();
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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = searchField.getText().trim();
                model.setRowCount(0);

                try{
                String[] data =x.searchStudent(str).lineRepresentation().split(",");
                model.addRow(data);}
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Invalid Name or ID!");
                }

        }});

        reloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                for (Record rec : x.returnAllStudents()) {
                    String[] data = rec.lineRepresentation().split(",");
                    model.addRow(data);
                }

            }
        });

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2 && table1.getSelectedRow() != -1) {
                    int selectedRow = table1.getSelectedRow();
                    String id = (String) model.getValueAt(selectedRow, 0);
                    Student s = x.searchStudent(id);

                    if (s != null) {
                        new UpdateStudent(s);
                        for (Record rec : x.returnAllStudents()) {
                            String[] data = rec.lineRepresentation().split(",");
                            model.addRow(data);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found!");
                    }
                }
            }
        });



    }



}
