import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {

    @Override
    public void doExport(List<Student> students) {

        System.out.println("Exportul a " + students.size() + " studenti s-a realizat in format XLSX.");
    }

    @Override
    public void exportData(List<Student> studenti) {

    }
}