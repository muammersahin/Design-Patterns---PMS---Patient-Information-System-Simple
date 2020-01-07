import java.io.FileNotFoundException;

public class AlarmAdapter implements Command {

    private Alarm alarm;

    public AlarmAdapter(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute(Patient patient) throws FileNotFoundException, InterruptedException {
        alarm.executeAlarm(patient);
    }
}
