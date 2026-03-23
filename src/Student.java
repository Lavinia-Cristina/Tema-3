public class Student {

    int numarMatricol;
    String nume;
    String prenume;
    String formatiedestudiu;

    Student ( int numarmatricolintrodus, String numeintrodus,String prenumeintrodus,String formatiedestudiuintrodus)
    {
        numarMatricol=numarmatricolintrodus;
        nume=numeintrodus;
        prenume=prenumeintrodus;
        formatiedestudiu=formatiedestudiuintrodus;

    }

    public String toString()
    {
        return "DATELE STUDENTILOR: " + "Numar matricol: " + numarMatricol + " , nume:" + nume + " , prenume:" + prenume + " , formatiedestudiu:" + formatiedestudiu;

    }


}
