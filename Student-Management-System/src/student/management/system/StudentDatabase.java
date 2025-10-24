package student.management.system;

public class StudentDatabase extends Database{

    public StudentDatabase(String filename) {
        super(filename);
    }

    @Override
    public Record createRecordFrom(String line) {

        String[] split = line.split(",");
        if(split.length !=6) {return null;}
        return new Student(split[0],split[1],Integer.parseInt(split[2]),split[3],split[4],Double.parseDouble(split[5]));
    }
}
