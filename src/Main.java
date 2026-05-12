import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // LAB1
        System.out.print("Clasa da aceste date: ");
        System.out.println();

        Student stud1 = new Student(527, "Botea", "Lavinia", "ISM21/2", 8.70);
        System.out.println(stud1);
        System.out.println();
        System.out.println();

        // LAB2
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(10);
        x.add(3);
        x.add(5);
        x.add(2);

        List<Integer> y = new ArrayList<>();
        y.add(1);
        y.add(2);
        y.add(3);
        y.add(5);
        y.add(4);
        y.add(6);
        y.add(7);

        Collections.sort(x);
        Collections.sort(y);

        List<Integer> xPlusY = new ArrayList<>(); // a
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.print(xPlusY);

        System.out.println();
        System.out.println();

        Set<Integer> zSet = new TreeSet<>(); // b
        zSet.addAll(x);
        zSet.retainAll(y);

        System.out.println("Elemente comune (zSet): " + zSet);
        System.out.println();

        List<Integer> xMinusY = new ArrayList<>(); // c
        xMinusY.addAll(x);
        xMinusY.removeAll(y);

        System.out.println("Elemente din x care nu sunt in y: " + xMinusY);
        System.out.println();

        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>(); // d
        for (Integer val : xPlusY) {
            if (val <= p) {
                xPlusYLimitedByP.add(val);
            }
        }

        System.out.println("Elemente din x si y <= " + p + ": " + xPlusYLimitedByP);

        // Partea Student
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student(101, "Popescu", "Ion", "TI21/1", 8.70));
        studenti.add(new Student(120, "Popa", "Alis", "TI21/2", 8.70)); // Studentul de la b)
        studenti.add(new Student(105, "Ionescu", "Dan", "TI21/1", 8.70));

        System.out.println("Lista de studenti:");
        for (Student s : studenti) {
            System.out.println(s);
        }

        Student cautat1 = new Student(120, "Popa", "Alis", "TI21/2", 8.70);
        Student cautat2 = new Student(112, "Popa", "Maria", "TI21/1", 8.70);

        System.out.println("Rezultate cautare:");
        System.out.println("Alis Popa este in lista? " + studenti.contains(cautat1));
        System.out.println("Maria Popa este in lista? " + studenti.contains(cautat2));

        // Citire din fisier
        Path inPath = Paths.get("src/studenti_in.txt");
        Path outPath = Paths.get("src/studenti_out.txt");

        List<String> lines = Files.readAllLines(inPath);
        List<Student> studentiDinFisier = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0].trim());
            String nume = parts[1].trim();
            String prenume = parts[2].trim();
            String grupa = parts[3].trim();

            studentiDinFisier.add(new Student(id, nume, prenume, grupa, 8.70));
        }

        System.out.println("Studenti cititi din fisier:");
        for (Student s : studentiDinFisier) {
            System.out.println(s);
        }
        System.out.println();

        Collections.sort(studentiDinFisier, (s1, s2) -> s1.nume.compareTo(s2.nume));

        List<String> outLines = new ArrayList<>();
        for (Student s : studentiDinFisier) {
            outLines.add(s.toString());
        }

        Files.write(outPath, outLines);
        System.out.println("Studentii sortati au fost salvati in fisier.");

        Map<Integer, Student> mapStudenti = new HashMap<>();
        for (Student s : studentiDinFisier) {
            mapStudenti.put(s.numarMatricol, s);
        }

        Path notePath = Paths.get("src/note_anon.txt");
        if (Files.exists(notePath)) {
            List<String> liniiNote = Files.readAllLines(notePath);
            for (String linie : liniiNote) {
                linie = linie.replace("\uFEFF", "").trim();
                if (linie.isEmpty()) {
                    continue;
                }

                String[] parts = linie.split(",");
                int idCitit = Integer.parseInt(parts[0].trim());
                float notaCitita = Float.parseFloat(parts[1].trim());

                Student studentCurent = mapStudenti.get(idCitit);
                if (studentCurent != null) {
                    studentCurent.setNota(notaCitita);
                }
            }
        } else {
            System.out.println("Fisierul note_anon.txt nu a fost gasit!");
        }

        System.out.println("\n--- Studenti cu note alocate ---");
        for (Student s : mapStudenti.values()) {
            System.out.println(s);
        }

        System.out.println("\nCautare note in O(1)");
        float notaM = gasesteNota("Bianca", "Popescu", mapStudenti);
        float notaN = gasesteNota("Ioan", "Mihalcea", mapStudenti);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Mihalcea: " + notaN);
        System.out.println();


        System.out.println("--- Initializare si Salvare Bursieri ---");

        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));

        for (StudentBursier b : bursieri) {
            System.out.println(b);
        }

        // Salvarea listei in fisier
        salveazaInFisier("src/bursieri_out.txt", bursieri);
        System.out.println("Lista de bursieri a fost salvata cu succes in 'src/bursieri_out.txt'.");


        //LAB 10
        IO.println("                                    ");
        IO.println("                                    ");
        IO.println("                                    ");
        IO.println("                                    ");

        AplicatieCuStrategy app = new AplicatieCuStrategy();

        IStudentiExport strategyConsole = new StudentiInConsola();

        Exporter exporter = new Exporter();

        exporter.startExport(strategyConsole, app.studenti);


    }



    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> mapaInitiala) {
        Map<String, Student> tineriFormatati = new HashMap<>();

        for (Student s : mapaInitiala.values()) {
            String cheie = s.prenume.trim().toLowerCase() + "-" + s.nume.trim().toLowerCase();
            tineriFormatati.put(cheie, s);
        }

        String cheieCautare = prenume.trim().toLowerCase() + "-" + nume.trim().toLowerCase();

        if (tineriFormatati.containsKey(cheieCautare)) {
            return tineriFormatati.get(cheieCautare).nota;
        }

        return 0f;
    }


    public static void salveazaInFisier(String numeFisier, Collection<? extends Student> colectie) throws IOException {
        Path path = Paths.get(numeFisier);
        List<String> linii = new ArrayList<>();

        for (Student s : colectie) {
            linii.add(s.toString());
        }

        Files.write(path, linii);
    }


}