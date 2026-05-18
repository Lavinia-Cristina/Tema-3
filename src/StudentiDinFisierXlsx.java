import java.util.ArrayList;
import java.util.List;

class StudentiDinFiserXlsx implements IStudentiImport {

    @Override
    public List<Student> doImport(String numeFisier) {
        List<Student> studenti = new ArrayList<>();
        // Simulare citire date
        System.out.println("Succes (Simulat): Import realizat din formatul Excel XLSX: '" + numeFisier + "'.");
        return studenti;
    }
}