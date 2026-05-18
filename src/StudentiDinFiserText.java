import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFiserText implements IStudentiImport {

    @Override
    public List<Student> doImport(String numeFisier) {
        List<Student> studenti = new ArrayList<>();
        try {
            List<String> linii = Files.readAllLines(Paths.get(numeFisier));
            for (String linie : linii) {
                String[] parts = linie.split(",");
                if (parts.length >= 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String nume = parts[1].trim();
                    String prenume = parts[2].trim();
                    String grupa = parts[3].trim();
                    double nota = parts.length > 4 ? Double.parseDouble(parts[4].trim()) : 0.0;

                    studenti.add(new Student(id, nume, prenume, grupa, nota));
                }
            }
            System.out.println("Import realizat din '" + numeFisier + "'.");
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisierul text: " + e.getMessage());
        }
        return studenti;
    }
}