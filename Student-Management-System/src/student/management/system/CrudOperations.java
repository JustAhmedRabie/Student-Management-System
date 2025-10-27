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
        ArrayList<Record> students = database.returnAllRecords();
        boolean swapped;
        for (int i = 0; i < students.size() - 1; i++) {
            swapped = false;

            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (Integer.parseInt(students.get(j).getStudentId()) > Integer.parseInt(students.get(j+1).getStudentId())) {
                    // Swap elements
                    Record temp = students.get(j);
                    students.set(j, students.get(j+1));
                    students.set(j+1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return students;
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

