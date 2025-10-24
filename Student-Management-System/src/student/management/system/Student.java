package student.management.system;



public class Student extends Record{

    private String studentId;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(String studentId, String fullName, int age, String gender, String department, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;

    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentId() {
        return studentId;
    }
    @Override
    public String lineRepresentation() {
        return studentId + "," + fullName + "," + String.valueOf(age) + "," + gender + "," + department + "," + String.valueOf(gpa);
    }

}
