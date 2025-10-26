package student.management.system;

import java.util.ArrayList;

public class CrudOperations {

    private StudentDatabase database;

    public CrudOperations(String fileName) {
        this.database = new StudentDatabase(fileName);
    }

    boolean addStudent(Student student) { //Make sure to validate student attributes before calling this function

        database.readFromFile();
        if(database.containsId(student.getStudentId())){return false; /* if ID already exists */}
        database.insertRecord(student);
        database.saveToFile();
        return  true;
    }

    ArrayList<Record> returnAllStudents() {
        database.readFromFile();
        return database.returnAllRecords();
    }

    void deleteStudent(Student student) {
        database.readFromFile();
        if(!database.containsId(student.getStudentId())) {return;}
        database.deleteRecord(student.getStudentId());
        database.saveToFile();
    }

    Student searchStudent(String studentId) { // if this function returns null it means there is no student with that ID
        database.readFromFile();
        return (Student) database.getRecord(studentId);
    }

    void updateStudent(String studentId, Student updatedStudent) {

        database.readFromFile();
        Record record = database.getRecord(studentId);
        if (record == null) {return;}


        Student s = (Student) record;

        s.setFullName(updatedStudent.getFullName());
        s.setAge(updatedStudent.getAge());
        s.setGender(updatedStudent.getGender());
        s.setDepartment(updatedStudent.getDepartment());
        s.setGpa(updatedStudent.getGpa());

        database.saveToFile();

    }
}

