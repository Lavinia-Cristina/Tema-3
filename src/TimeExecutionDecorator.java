import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    @Override
    public Long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        super.executionTime(studenti);
        long endTime = System.currentTimeMillis();
        long execTime = endTime - startTime;
        System.out.println("Timpul de executie în milisecunde: " + execTime);
        return execTime;
    }


    public long executionTime() {
        return this.executionTime(this.studenti);
    }
}