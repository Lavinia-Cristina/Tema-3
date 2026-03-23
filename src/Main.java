
void main() throws IOException {
//LAB1
    IO.print("Clasa da aceste date: ");
    IO.println();

    Student stud1= new Student( 527, "Botea", "Lavinia", "ISM21/2");
    IO.println(stud1);

    IO.println();
    IO.println();


    //LAB2



    List<Integer> x = new ArrayList();

    x.add(1);
    x.add(10);
    x.add(3);
    x.add(5);
    x.add(2);



    List<Integer> y = new ArrayList();

    y.add(1);
    y.add(2);
    y.add(3);
    y.add(5);
    y.add(4);
    y.add(6);
    y.add(7);

    Collections.sort(x);
    Collections.sort(y);

    List<Integer> xPlusY = new ArrayList(); //a
    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    IO.print(xPlusY);


    IO.println();
    IO.println();



    Set<Integer> zSet = new TreeSet(); //b
    zSet.addAll(x);
    zSet.retainAll(y);


    IO.println("Elemente comune (zSet): " + zSet);
    IO.println();




    List<Integer> xMinusY = new ArrayList();//c

    xMinusY.addAll(x);
    xMinusY.removeAll(y);

    IO.println("Elemente din x care nu sunt in y: " + xMinusY);
    IO.println();

    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList(); //d
    for (Integer val : xPlusY) {
        if (val <= p) {
            xPlusYLimitedByP.add(val);
        }
    }

    IO.println("Elemente din x si y <= " + p + ": " + xPlusYLimitedByP);



    //Partea Student

    List<Student> studenti = new ArrayList<>();
    studenti.add(new Student(101, "Popescu", "Ion", "TI21/1"));
    studenti.add(new Student(120, "Popa", "Alis", "TI21/2")); // Studentul de la b)
    studenti.add(new Student(105, "Ionescu", "Dan", "TI21/1"));


    System.out.println("Lista de studenti:");
    for (Student s : studenti) {
        System.out.println(s);
    }


    Student cautat1 = new Student(120, "Popa", "Alis", "TI21/2");
    Student cautat2 = new Student(112, "Popa", "Maria", "TI21/1");

    System.out.println("Rezultate cautare:");
    System.out.println("Alis Popa este in lista? " + studenti.contains( cautat1));
    System.out.println("Maria Popa este in lista? " + studenti.contains( cautat1));
//citire din fisier

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

        studentiDinFisier.add(new Student(id, nume, prenume, grupa));
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


}


