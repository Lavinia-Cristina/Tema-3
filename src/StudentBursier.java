import java.util.Objects;

public class StudentBursier extends Student {
    double cuantumBursa;


    public StudentBursier(int numarMatricol, String nume, String prenume, String formatiedestudiu, double nota, double cuantumBursa) {

        super(numarMatricol, nume, prenume, formatiedestudiu);

        this.setNota((float) nota);
        this.cuantumBursa = cuantumBursa;
    }



    public String toString() {
        return super.toString() + " , cuantum bursa: " + cuantumBursa;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBursier that = (StudentBursier) o;
        return numarMatricol == that.numarMatricol;
    }

    // Implementarea hashCode() corespunzatoare

    public int hashCode() {
        return Objects.hash(numarMatricol);
    }

}