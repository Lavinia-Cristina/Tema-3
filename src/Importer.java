import java.util.List;

public class Importer {
    public List<Student> startImport(IStudentiImport strategyInstance, String numeFisier) {
        return strategyInstance.doImport(numeFisier);
    }
}