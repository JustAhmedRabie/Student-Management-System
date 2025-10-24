package student.management.system;

import java.util.ArrayList;

public class CrudOperations {

    private StudentDatabase database;

    public CrudOperations(String fileName) {
        this.database = new StudentDatabase(fileName);
    }

    void addStudent(Student student) { //Make sure to validate student attributes before calling this function

        database.readFromFile();
        if(database.containsId(student.getStudentId())){return; /* if ID already exists */}
        database.insertRecord(student);
        database.saveToFile();
    }

    ArrayList<Record> returnAllStudents() {
        database.readFromFile();
        return database.returnAllRecords();
    }

    void deleteStudent(Student student) {
        if(student == null)
            return;
        database.readFromFile();
        database.deleteRecord(student.getStudentId());
        database.saveToFile();
    }

    Student searchStudent(String studentId) { // if this function returns null it means there is no student with that ID
        database.readFromFile();
        return (Student) database.getRecord(studentId);
    }
}
