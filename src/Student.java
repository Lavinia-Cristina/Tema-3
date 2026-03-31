public class Student {

    int numarMatricol;
    String nume;
    String prenume;
    String formatiedestudiu;
    float nota;

    Student ( int numarmatricolintrodus, String numeintrodus,String prenumeintrodus,String formatiedestudiuintrodus)
    {
        numarMatricol=numarmatricolintrodus;
        nume=numeintrodus;
        prenume=prenumeintrodus;
        formatiedestudiu=formatiedestudiuintrodus;

    }
    public void setNota(float nota) {
        this.nota = nota;
    }
    public String getNume(){
        return this.nume;
    }

    public String getFormatiedestudiu(){
        return this.formatiedestudiu;
    }
    public String toString()
    {
        return "DATELE STUDENTILOR: " + "Numar matricol: " + numarMatricol + " , nume:" + nume + " , prenume:" + prenume + " , formatiedestudiu:" + formatiedestudiu + "nota" + nota;

    }


}
