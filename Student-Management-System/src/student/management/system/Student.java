package student.management.system;



public class Student extends {

    private int studentId;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(int studentId, String fullName, int age, String gender, String department, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
        
    }

    public String lineRepresentation() {
        return  + "," + fullName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;    }
