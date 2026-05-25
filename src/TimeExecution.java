import java.util.List;

public abstract class TimeExecution implements ITimeExecution {
    protected IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }


    public Long executionTime(List<Student> studenti) {

        exporter.exportData(studenti);
        return 0L;
    }
}