import java.util.List;

public class StudentiInConsola implements IStudentiExport {


    public void doExport(List<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}